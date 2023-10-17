package com.techelevator.models;

import java.math.BigDecimal;

public abstract class VendingItem {
    private String slotLocation;
    private String name;
    private BigDecimal price;
    private String type;
    private int quantity;

    public VendingItem(String slotLocation, String name, BigDecimal price, String type, int quantity) {
        this.slotLocation = slotLocation;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity=6;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public void setSlotLocation(String slotLocation) {
        this.slotLocation = slotLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void inventoryTracker() {
        this.quantity -= 1;
    }
    public abstract String purchaseMessage();
}

