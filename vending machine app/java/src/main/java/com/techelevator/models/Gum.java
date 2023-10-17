package com.techelevator.models;

import java.math.BigDecimal;

public class Gum extends VendingItem {
    public Gum(String slotLocation, String name, BigDecimal price, String type) {
        super(slotLocation, name, price, type,6);
    }

    @Override
    public String purchaseMessage() {
        return "Chewy, Chewy, Lots O Bubbles!";
    }
}
