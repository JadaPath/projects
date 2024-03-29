package com.techelevator.ui;

import com.techelevator.application.VendingMachine;
import com.techelevator.models.VendingItem;

import java.math.BigDecimal;
import java.util.Map;


/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput
{

    public void displayMessage(String message)
    {
        System.out.println(message);
    }

    public void displayHomeScreen()
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public void displayVendingSlots() {
        System.out.println();
        System.out.println("Slot | Item Name | Price | Type");
    }
    public void errorMessage() {
        System.out.println("Invalid entry. Please try again.");
    }
    }

