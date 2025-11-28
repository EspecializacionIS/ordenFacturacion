package com.clinic.facturacion.domain.repository;

import java.util.Optional;

import com.clinic.facturacion.domain.model.Order;

public interface OrderRepositoryPort {
	
	Order save(Order order);
    Optional<Order> findByOrderNumber(String orderNumber);

}
