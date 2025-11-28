package com.clinic.facturacion.domain.repository;

import java.util.Optional;

import com.clinic.facturacion.domain.model.Invoice;

public interface InvoiceRepositoryPort {
	
	Invoice save(Invoice invoice);

	Optional<Invoice> findByInvoiceNumber(String invoiceNumber);

}
