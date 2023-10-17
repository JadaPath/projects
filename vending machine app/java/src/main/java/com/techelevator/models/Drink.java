package com.techelevator.models;

import java.math.BigDecimal;

public class Drink extends VendingItem {
    public Drink(String slotLocation, String name, BigDecimal price, String type) {
        super(slotLocation, name, price, type,6);
    }

    @Override
    public String purchaseMessage() {
        return "Drinky, Drinky, Slurp Slurp!";
    }
}
