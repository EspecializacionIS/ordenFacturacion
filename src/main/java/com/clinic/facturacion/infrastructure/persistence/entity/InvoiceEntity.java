package com.clinic.facturacion.infrastructure.persistence.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "invoices")
@Data
public class InvoiceEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String invoiceNumber;

    private String orderNumber;

    private String patientId;

    private LocalDateTime issuedAt;

    private BigDecimal total;

    private BigDecimal copayment;

    private BigDecimal payableByInsurance;

    private BigDecimal payableByPatient;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public LocalDateTime getIssuedAt() {
		return issuedAt;
	}

	public void setIssuedAt(LocalDateTime issuedAt) {
		this.issuedAt = issuedAt;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getCopayment() {
		return copayment;
	}

	public void setCopayment(BigDecimal copayment) {
		this.copayment = copayment;
	}

	public BigDecimal getPayableByInsurance() {
		return payableByInsurance;
	}

	public void setPayableByInsurance(BigDecimal payableByInsurance) {
		this.payableByInsurance = payableByInsurance;
	}

	public BigDecimal getPayableByPatient() {
		return payableByPatient;
	}

	public void setPayableByPatient(BigDecimal payableByPatient) {
		this.payableByPatient = payableByPatient;
	}
}
