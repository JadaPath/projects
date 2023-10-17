package com.techelevator.ui;

import com.techelevator.application.VendingMachine;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput {
    private static Scanner scanner = new Scanner(System.in);
    private BigDecimal money = new BigDecimal("0");
    private String moneyAdded = "";
    private BigDecimal userMoney = new BigDecimal("0");


    public String getHomeScreenOption() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Vending Machine Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        if (option.equalsIgnoreCase("d")) {
            return "display";
        } else if (option.equals("p")) {
            return "purchase";
        } else if (option.equals("e")) {
            return "exit";
        } else {
            return "";
        }

    }

    public String displayPurchaseMenu() {
        System.out.println("(M) Feed Money");
        System.out.println("(S) Select Item");
        System.out.println("(F) Finish Transaction");
        System.out.println();
        System.out.println("Current Money Provided: $" + userMoney);
        String purchaseOption = scanner.nextLine();
        return purchaseOption;
    }

    public BigDecimal feedMoneyMenu() {

        System.out.println("(1) Add $1");
        System.out.println("(5) Add $5");
        System.out.println("(10) Add $10");
        System.out.println("(20) Add $20");
        System.out.println("(R) Return to previous");
        moneyAdded = scanner.nextLine();
        money = new BigDecimal("0");
        if (moneyAdded.equals("1")) {
            money=(money.add(new BigDecimal("1")));
            return money;
        } else if (moneyAdded.equals("5")) {
            money=(money.add(new BigDecimal("5")));
            return money;
        } else if (moneyAdded.equals("10")) {
            money=(money.add(new BigDecimal("10")));
            return money;
        } else if (moneyAdded.equals("20")) {
            money=(money.add(new BigDecimal("20")));
            return money;
        } else if (moneyAdded.equals("R")) {

        } else {
            System.out.println("Error: Invalid entry. Please try again.");
            System.exit(1);
        }
        return money;

    }

    public BigDecimal getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }

    public String optionSelected() {
        String choiceEntered = scanner.nextLine();
        return choiceEntered;
    }
}



