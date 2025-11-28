package com.clinic.facturacion.application.usecase;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.clinic.facturacion.domain.repository.*;
import com.clinic.facturacion.domain.model.*;
import com.clinic.facturacion.domain.service.BillingServicePort;

@Service
public class GenerateInvoiceUseCase implements BillingServicePort{
	
	private final OrderRepositoryPort orderRepo;
    private final PatientRepositoryPort patientRepo;
    private final InvoiceRepositoryPort invoiceRepo;
    
    private static final BigDecimal COPAY = new BigDecimal("50000");
    private static final BigDecimal COPAY_YEARLY_CAP = new BigDecimal("1000000");
    
    public GenerateInvoiceUseCase(OrderRepositoryPort orderRepo,
            PatientRepositoryPort patientRepo,
            InvoiceRepositoryPort invoiceRepo) {
    	this.orderRepo = orderRepo;
    	this.patientRepo = patientRepo;
    	this.invoiceRepo = invoiceRepo;
    }
    
    @Override
    public Invoice generateInvoice(Order order) {
        // calculate total cost of all items
        BigDecimal total = order.getItems().stream()
            .map(i -> i.getUnitCost().multiply(new BigDecimal(i.getQuantity())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        LocalDate today = LocalDate.now();
        InsurancePolicy policy = patientRepo.findPolicyByPatientId(order.getPatientId()).orElse(null);

        BigDecimal copay = BigDecimal.ZERO;
        BigDecimal payableByInsurance = BigDecimal.ZERO;
        BigDecimal payableByPatient = BigDecimal.ZERO;

        if (policy != null && Boolean.TRUE.equals(policy.getActive()) && policy.getExpirationDate()!=null && policy.getExpirationDate().isAfter(today)) {
            // revisar tope anual
            double accumulated = patientRepo.getAccumulatedCopayThisYear(order.getPatientId(), today.getYear());
            if (BigDecimal.valueOf(accumulated).compareTo(COPAY_YEARLY_CAP) >= 0) {
                // tope alcanzado, no paga copago
                copay = BigDecimal.ZERO;
                payableByInsurance = total;
                payableByPatient = BigDecimal.ZERO;
            } else {
                // paciente paga copago (si total > copay, sino paga lo que haya)
                copay = COPAY.min(total);
                // aseguradora paga resto
                payableByInsurance = total.subtract(copay).max(BigDecimal.ZERO);
                payableByPatient = copay;
                // acumular
                patientRepo.addCopay(order.getPatientId(), today.getYear(), copay.doubleValue());
            }
        } else {
            // sin póliza o póliza inactiva => paciente paga todo
            copay = BigDecimal.ZERO;
            payableByInsurance = BigDecimal.ZERO;
            payableByPatient = total;
        }

        Invoice invoice = new Invoice();
        invoice.setInvoiceNumber("INV-" + UUID.randomUUID().toString().substring(0,8).toUpperCase());
        invoice.setOrderNumber(order.getOrderNumber());
        invoice.setPatientId(order.getPatientId());
        invoice.setIssuedAt(LocalDateTime.now());
        invoice.setBilledItems(order.getItems());
        invoice.setTotal(total);
        invoice.setCopayment(copay);
        invoice.setPayableByInsurance(payableByInsurance);
        invoice.setPayableByPatient(payableByPatient);

        invoiceRepo.save(invoice);
        return invoice;
    }
}
