package com.atmv2;

public class MoneyAmount {
    private double amount;

    public MoneyAmount (double amountbase) {
        this.amount = amountbase;
    }

    public double getAmount() {
        return amount;
    }

    public void addMoneytoAccount (double moneyIn) {
        System.out.println("Insert the money in the ATM");
        System.out.println("Processing the amount inserted...");
        if (moneyIn > 0) {
            amount += moneyIn;
            System.out.println("You have added" + moneyIn + " to your own account.");
        } else {
            System.out.println("You have not insert money in the ATM. Do it again.");
        }
    }

    public void depositeMoney (double moneyDeposited) {
        System.out.println("Write the account number you want to deposit");
        if (moneyDeposited > 0) {
            amount -= moneyDeposited;
            System.out.println("You have deposited " + moneyDeposited + " successfully.");
        } else {
            System.out.println("Invalid amount. Please try again.");
        }
    }

    public boolean withdrawMoney (double moneyWithdrawned) {
        System.out.println("Write the money you wanto to withdraw");
        if (moneyWithdrawned > 0 && moneyWithdrawned <= amount) {
            amount -= moneyWithdrawned;
            System.out.println("You have withdrawn " + moneyWithdrawned + " successfully.");
            return true;
        } else {
            System.out.println("Invalid amount. Please try again.");
            return false;
        }
    }

}
