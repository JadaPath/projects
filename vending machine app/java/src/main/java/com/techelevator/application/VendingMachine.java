package com.techelevator.application;

import com.techelevator.logger.Logger;
import com.techelevator.models.*;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {

    private UserOutput userOutput;
    private UserInput userInput;
    private Logger logger;
    private List<VendingItem> vendingList;
    private BigDecimal moneyGiven = new BigDecimal("0");
    private BigDecimal userFundsAvailable = new BigDecimal("0");
    private String slotChosen = "";
    private int dollarChange = 0;
    private int quarterChange = 0;
    private int dimeChange = 0;
    private int nickelChange = 0;
    private final BigDecimal QUARTER_VALUE = new BigDecimal("0.25");
    private final BigDecimal DIME_VALUE = new BigDecimal("0.10");
    private final BigDecimal NICKEL_VALUE = new BigDecimal("0.05");
    private LocalDateTime currentDateAndTime = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
    private BigDecimal preTransactionBalance = new BigDecimal("0");
    private BigDecimal totalChange = new BigDecimal("0");
    private int numberOfPurchases = 0;
    private final BigDecimal discount = new BigDecimal("1");



    public VendingMachine() {
        this.userInput = new UserInput();
        this.userOutput = new UserOutput();
        logger = new Logger("audit.txt");
        vendingList = new ArrayList<>();


    }

    public void run() {
        while (true) {
            readFromFile();
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();

            if (choice.equalsIgnoreCase("display")) {
                userOutput.displayVendingSlots();
                for (VendingItem item : vendingList) {
                    System.out.println((item.getSlotLocation() + " |   " + item.getName() + " |  " + item.getPrice() + " |  " + item.getType()));
                }

            } else if (choice.equals("purchase")) {

                String userChoice = userInput.displayPurchaseMenu();

                if (userChoice.equalsIgnoreCase("M")) {
                    calculateMoneyAvailable();

                }
                if (userChoice.equalsIgnoreCase("S")) {
                    userOutput.displayVendingSlots();
                    for (VendingItem item : vendingList) {
                        System.out.println((item.getSlotLocation() + " |   " + item.getName() + " |  " + item.getPrice() + " |  " + item.getType()));
                    }
                    userOutput.displayMessage("enter your choice");
                    slotChosen = userInput.optionSelected();
                    numberOfPurchases++;
                    for (VendingItem item : vendingList) {
                        if (slotChosen.equals(item.getSlotLocation())) {
                            if (item.getQuantity() > 0) {


                                if (userFundsAvailable.compareTo(item.getPrice()) >= 0) {
                                    preTransactionBalance = userFundsAvailable;
                                    if (numberOfPurchases % 2 == 0) {
                                        item.setPrice(item.getPrice().subtract(discount));
                                    }
                                    userFundsAvailable = userFundsAvailable.subtract(item.getPrice());
                                    userInput.setUserMoney(userFundsAvailable);
                                    item.inventoryTracker();
                                    userOutput.displayMessage("you have purchased " + item.getName() + " you have $" + userFundsAvailable + " remaining.");
                                    userOutput.displayMessage(item.purchaseMessage());
                                    logger.write(currentDateAndTime.format(format) + " " + item.getName() + " " + item.getSlotLocation() + " $" + preTransactionBalance + " $" + userFundsAvailable);
                                    if (numberOfPurchases % 2 == 0) {
                                        item.setPrice(item.getPrice().add(discount));
                                    }
                                    break;
                                } else if (userFundsAvailable.compareTo(item.getPrice()) < 0) {
                                    userOutput.displayMessage("Sorry, you have not provided enough funds for this item.");
                                    break;
                                }


                            } else {
                                userOutput.displayMessage("This item is no longer available.");
                                break;
                            }
                        }
                    }
                }

                if (userChoice.equalsIgnoreCase("F")) {
                        userOutput.displayMessage("you're remaining funds is " + userFundsAvailable);
                        totalChange = userFundsAvailable;
                        while (userFundsAvailable.compareTo(new BigDecimal("1")) >= 0) {
                            dollarChange++;
                            userFundsAvailable = userFundsAvailable.subtract(new BigDecimal("1"));

                        } while (userFundsAvailable.compareTo(QUARTER_VALUE) >= 0) {
                            quarterChange++;
                            userFundsAvailable = userFundsAvailable.subtract(QUARTER_VALUE);
                        } while (userFundsAvailable.compareTo(DIME_VALUE) >= 0) {
                            dimeChange++;
                            userFundsAvailable = userFundsAvailable.subtract(DIME_VALUE);
                        } while (userFundsAvailable.compareTo(NICKEL_VALUE) >= 0) {
                            nickelChange++;
                            userFundsAvailable = userFundsAvailable.subtract(NICKEL_VALUE);
                        }
                        userOutput.displayMessage("Your change is " + dollarChange + " 1-dollar bills, " + quarterChange + " quarters, "
                                + dimeChange + " dimes, and " + nickelChange + " nickels.");
                        logger.write(currentDateAndTime.format(format) + " CHANGE GIVEN: $" + totalChange + " $" + userFundsAvailable);
                        break;
                    }


                } else if (choice.equals("exit")) {
                    // good bye
                    break;
                }

            }
        }

        public void readFromFile () {
            File file = new File("catering.csv");
            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] inventory = line.split(",");
                    String itemLocation = inventory[0];
                    String itemName = inventory[1];
                    BigDecimal itemPrice = new BigDecimal(inventory[2]);
                    String itemType = inventory[3];

                    if (itemType.equals("Munchy")) {
                        vendingList.add(new Munchies(itemLocation, itemName, itemPrice, itemType));
                    } else if (itemType.equals("Candy")) {
                        vendingList.add(new Candy(itemLocation, itemName, itemPrice, itemType));
                    } else if (itemType.equals("Drink")) {
                        vendingList.add(new Drink(itemLocation, itemName, itemPrice, itemType));
                    } else if (itemType.equals("Gum")) {
                        vendingList.add(new Gum(itemLocation, itemName, itemPrice, itemType));
                    }
                }
            } catch (FileNotFoundException e) {
                userOutput.displayMessage("File not found");
            }

        }
    

        public BigDecimal calculateMoneyAvailable () {


            moneyGiven = userInput.feedMoneyMenu();
            userFundsAvailable = userFundsAvailable.add((moneyGiven));
            logger.write(currentDateAndTime.format(format) + " MONEY FED: $" + moneyGiven + " $" + userFundsAvailable);
            userInput.setUserMoney(userFundsAvailable);
            return moneyGiven;
        }



    }





