package com.clinic.facturacion.infrastructure.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinic.facturacion.infrastructure.persistence.entity.InvoiceEntity;

public interface SpringInvoiceRepository extends JpaRepository<InvoiceEntity, Long> {
	
	Optional<InvoiceEntity> findByInvoiceNumber(String invoiceNumber);

}
