package com.clinic.facturacion.infrastructure.persistence.repository;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.clinic.facturacion.domain.model.Order;
import com.clinic.facturacion.domain.repository.OrderRepositoryPort;
import com.clinic.facturacion.infrastructure.persistence.entity.OrderEntity;
import com.clinic.facturacion.infrastructure.persistence.mapper.OrderMapper;

@Component
public class OrderRepositoryAdapter implements OrderRepositoryPort {
	
	private final SpringOrderRepository repo;
    private final OrderMapper mapper;

    public OrderRepositoryAdapter(SpringOrderRepository repo, OrderMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public Order save(Order order) {
        OrderEntity entity = mapper.toEntity(order);
        entity = repo.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public Optional<Order> findByOrderNumber(String orderNumber) {
        return repo.findByOrderNumber(orderNumber)
                .map(mapper::toDomain);
    }

}
