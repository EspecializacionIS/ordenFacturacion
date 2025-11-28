package com.clinic.facturacion.domain.service;

import com.clinic.facturacion.domain.model.Invoice;
import com.clinic.facturacion.domain.model.Order;

public interface BillingServicePort {
	
	Invoice generateInvoice(Order order);

}
