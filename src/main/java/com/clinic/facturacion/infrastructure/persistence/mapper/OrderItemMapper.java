package com.clinic.facturacion.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import com.clinic.facturacion.domain.model.OrderItem;
import com.clinic.facturacion.infrastructure.persistence.entity.OrderEntity;
import com.clinic.facturacion.infrastructure.persistence.entity.OrderItemEntity;

@Component
public class OrderItemMapper {
	
	public OrderItemEntity toEntity(OrderItem i, OrderEntity order) {
        OrderItemEntity e = new OrderItemEntity();
        e.setItemNumber(i.getItemNumber());
        e.setType(i.getType());
        e.setName(i.getName());
        e.setQuantity(i.getQuantity());
        e.setDose(i.getDose());
        e.setUnitCost(i.getUnitCost());
        e.setRequiresSpecialist(i.getRequiresSpecialist());
        e.setSpecialtyId(i.getSpecialtyId());
        e.setOrder(order);
        return e;
    }

    public OrderItem toDomain(OrderItemEntity e) {
        OrderItem i = new OrderItem();
        i.setItemNumber(e.getItemNumber());
        i.setType(e.getType());
        i.setName(e.getName());
        i.setQuantity(e.getQuantity());
        i.setDose(e.getDose());
        i.setUnitCost(e.getUnitCost());
        i.setRequiresSpecialist(e.getRequiresSpecialist());
        i.setSpecialtyId(e.getSpecialtyId());
        return i;
    }

}
