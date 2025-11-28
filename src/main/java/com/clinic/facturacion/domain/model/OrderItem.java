package com.clinic.facturacion.domain.model;

import java.math.BigDecimal;

public class OrderItem {
	
	private Integer itemNumber; // ítem dentro de la orden
    private ItemType type;
    private String name;
    private Integer quantity; // para medicamento: cantidad; para procedimiento: num veces
    private String dose; // opcional para medicamentos
    private BigDecimal unitCost;
    private Boolean requiresSpecialist;
    private Integer specialtyId; // nullable
	
    public OrderItem() {
		super();
	}

	public OrderItem(Integer itemNumber, ItemType type, String name, Integer quantity, String dose, BigDecimal unitCost,
			Boolean requiresSpecialist, Integer specialtyId) {
		super();
		this.itemNumber = itemNumber;
		this.type = type;
		this.name = name;
		this.quantity = quantity;
		this.dose = dose;
		this.unitCost = unitCost;
		this.requiresSpecialist = requiresSpecialist;
		this.specialtyId = specialtyId;
	}

	public Integer getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(Integer itemNumber) {
		this.itemNumber = itemNumber;
	}

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
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
