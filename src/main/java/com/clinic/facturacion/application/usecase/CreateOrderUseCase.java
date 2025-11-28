package com.clinic.facturacion.application.usecase;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.clinic.facturacion.domain.model.Order;
import com.clinic.facturacion.domain.repository.OrderRepositoryPort;

@Service
public class CreateOrderUseCase {
	
	private final OrderRepositoryPort orderRepo;

    public CreateOrderUseCase(OrderRepositoryPort orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Order create(Order order) {
        order.setCreatedAt(LocalDateTime.now());
        return orderRepo.save(order);
    }

    public Order findByOrderNumber(String orderNumber) {
        return orderRepo.findByOrderNumber(orderNumber)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));
    }

}
