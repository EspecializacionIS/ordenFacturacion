package com.clinic.facturacion.infrastructure.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinic.facturacion.infrastructure.persistence.entity.OrderEntity;

public interface SpringOrderRepository extends JpaRepository<OrderEntity, Long> {
	
	Optional<OrderEntity> findByOrderNumber(String orderNumber);

}
