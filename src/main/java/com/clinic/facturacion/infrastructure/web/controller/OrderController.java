package com.clinic.facturacion.infrastructure.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinic.facturacion.application.usecase.CreateOrderUseCase;
import com.clinic.facturacion.application.usecase.GenerateInvoiceUseCase;
import com.clinic.facturacion.domain.model.Invoice;
import com.clinic.facturacion.domain.model.Order;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	private final CreateOrderUseCase createOrder;
    private final GenerateInvoiceUseCase generateInvoice;

    public OrderController(CreateOrderUseCase createOrder,
                           GenerateInvoiceUseCase generateInvoice) {
        this.createOrder = createOrder;
        this.generateInvoice = generateInvoice;
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order) {
        return ResponseEntity.ok(createOrder.create(order));
    }

    @PostMapping("/{orderNumber}/invoice")
    public ResponseEntity<Invoice> invoice(@PathVariable String orderNumber) {
        Order order = createOrder.findByOrderNumber(orderNumber);
        return ResponseEntity.ok(generateInvoice.generateInvoice(order));
    }

}
