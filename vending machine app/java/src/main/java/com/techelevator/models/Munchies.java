package com.techelevator.models;

import java.math.BigDecimal;

public class Munchies extends VendingItem{
    public Munchies(String slotLocation, String name, BigDecimal price, String type) {
        super(slotLocation, name, price, type,6);
    }

    @Override
    public String purchaseMessage() {
        return "Munchy, Munchy, so Good!";
    }
}
