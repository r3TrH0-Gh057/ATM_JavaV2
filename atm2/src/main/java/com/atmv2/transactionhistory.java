package com.atmv2;
import java.util.ArrayList;
import java.util.List;

public class transactionhistory {
    private List <String> history;

    public transactionhistory() {
        history = new ArrayList<>();

    }

    public void register (String message) {
        history.add (message);

    }

    public void showhistory () {
        if (history.isEmpty()) {
            System.out.println("No transaction history");
        } else {
            System.out.println("Transaction history: ");
            for (String transactionHistory : history) {
                System.out.println(transactionHistory);
                
            }

        }
    }

}
