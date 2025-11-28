package com.clinic.facturacion.infrastructure.persistence.repository;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.clinic.facturacion.domain.model.Invoice;
import com.clinic.facturacion.domain.repository.InvoiceRepositoryPort;
import com.clinic.facturacion.infrastructure.persistence.entity.InvoiceEntity;
import com.clinic.facturacion.infrastructure.persistence.mapper.InvoiceMapper;

@Component
public class InvoiceRepositoryAdapter implements InvoiceRepositoryPort {
	
	private final SpringInvoiceRepository repo;
    private final InvoiceMapper mapper;

    public InvoiceRepositoryAdapter(SpringInvoiceRepository repo, InvoiceMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public Invoice save(Invoice invoice) {
        InvoiceEntity entity = mapper.toEntity(invoice);
        return mapper.toDomain(repo.save(entity));
    }

    public Optional<Invoice> findByInvoiceNumber(String invoiceNumber) {
        return repo.findByInvoiceNumber(invoiceNumber).map(mapper::toDomain);
    }
}
