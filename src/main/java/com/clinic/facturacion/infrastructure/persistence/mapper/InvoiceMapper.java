package com.clinic.facturacion.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import com.clinic.facturacion.domain.model.Invoice;
import com.clinic.facturacion.infrastructure.persistence.entity.InvoiceEntity;

@Component
public class InvoiceMapper {
	
	public InvoiceEntity toEntity(Invoice inv) {
        InvoiceEntity e = new InvoiceEntity();
        e.setId(inv.getId());
        e.setInvoiceNumber(inv.getInvoiceNumber());
        e.setOrderNumber(inv.getOrderNumber());
        e.setPatientId(inv.getPatientId());
        e.setIssuedAt(inv.getIssuedAt());
        e.setTotal(inv.getTotal());
        e.setCopayment(inv.getCopayment());
        e.setPayableByInsurance(inv.getPayableByInsurance());
        e.setPayableByPatient(inv.getPayableByPatient());
        return e;
    }
	
	public Invoice toDomain(InvoiceEntity e) {
        Invoice inv = new Invoice();
        inv.setId(e.getId());
        inv.setInvoiceNumber(e.getInvoiceNumber());
        inv.setOrderNumber(e.getOrderNumber());
        inv.setPatientId(e.getPatientId());
        inv.setIssuedAt(e.getIssuedAt());
        inv.setTotal(e.getTotal());
        inv.setCopayment(e.getCopayment());
        inv.setPayableByInsurance(e.getPayableByInsurance());
        inv.setPayableByPatient(e.getPayableByPatient());
        return inv;
    }



}
