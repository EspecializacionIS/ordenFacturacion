package com.clinic.facturacion.infrastructure.web.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InvoiceResponse {
	
	private String invoiceNumber;
    private String orderNumber;
    private LocalDateTime issuedAt;
    private BigDecimal total;
    private BigDecimal copayment;
    private BigDecimal payableByInsurance;
    private BigDecimal payableByPatient;
    
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
