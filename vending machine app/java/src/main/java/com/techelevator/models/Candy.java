package com.techelevator.models;

import java.math.BigDecimal;

public class Candy extends VendingItem {
    public Candy(String slotLocation, String name, BigDecimal price, String type) {
        super(slotLocation, name, price, type, 6);
    }

    @Override
    public String purchaseMessage() {
        return "Sugar, Sugar, so Sweet!";
    }
}
