package com.clinic.facturacion.infrastructure.persistence.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.clinic.facturacion.domain.model.Order;
import com.clinic.facturacion.infrastructure.persistence.entity.OrderEntity;

@Component
public class OrderMapper {
	
	private final OrderItemMapper itemMapper;

    public OrderMapper(OrderItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    public OrderEntity toEntity(Order order) {
        OrderEntity e = new OrderEntity();
        e.setId(order.getId());
        e.setOrderNumber(order.getOrderNumber());
        e.setPatientId(order.getPatientId());
        e.setDoctorId(order.getDoctorId());
        e.setCreatedAt(order.getCreatedAt());
        e.setItems(order.getItems().stream()
                .map(i -> itemMapper.toEntity(i, e))
                .collect(Collectors.toList()));
        return e;
    }

    public Order toDomain(OrderEntity e) {
        Order o = new Order();
        o.setId(e.getId());
        o.setOrderNumber(e.getOrderNumber());
        o.setPatientId(e.getPatientId());
        o.setDoctorId(e.getDoctorId());
        o.setCreatedAt(e.getCreatedAt());
        o.setItems(e.getItems().stream()
                .map(itemMapper::toDomain)
                .collect(Collectors.toList()));
        return o;
    }

}
