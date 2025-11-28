package com.clinic.facturacion.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
	
	private Long id;
    private String orderNumber; // máximo 6 dígitos
    private String patientId; // cédula
    private String doctorId; // cédula
    private LocalDateTime createdAt;
    private List<OrderItem> items;
    private ItemType mainType; // opcional, o derive por items
	
    public Order() {
		super();
	}

	public Order(Long id, String orderNumber, String patientId, String doctorId, LocalDateTime createdAt,
			List<OrderItem> items, ItemType mainType) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.createdAt = createdAt;
		this.items = items;
		this.mainType = mainType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public ItemType getMainType() {
		return mainType;
	}

	public void setMainType(ItemType mainType) {
		this.mainType = mainType;
	}
}
