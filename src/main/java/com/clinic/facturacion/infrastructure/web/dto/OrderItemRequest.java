package com.clinic.facturacion.infrastructure.web.dto;

import java.math.BigDecimal;

public class OrderItemRequest {
	
	private Integer itemNumber;
    private String type; // usar ItemType.name()
    private String name;
    private Integer quantity;
    private String dose;
    private BigDecimal unitCost;
    private Boolean requiresSpecialist;
    private Integer specialtyId;
	
    public Integer getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(Integer itemNumber) {
		this.itemNumber = itemNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getDose() {
		return dose;
	}
	public void setDose(String dose) {
		this.dose = dose;
	}
	public BigDecimal getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(BigDecimal unitCost) {
		this.unitCost = unitCost;
	}
	public Boolean getRequiresSpecialist() {
		return requiresSpecialist;
	}
	public void setRequiresSpecialist(Boolean requiresSpecialist) {
		this.requiresSpecialist = requiresSpecialist;
	}
	public Integer getSpecialtyId() {
		return specialtyId;
	}
	public void setSpecialtyId(Integer specialtyId) {
		this.specialtyId = specialtyId;
	}
}
