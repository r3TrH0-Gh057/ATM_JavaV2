package models;

public class Account {
    private int pin;
    private boolean blockAccount;
    private int attemptsfailed;

    public Account (int pin) {
        this.pin = pin;
        this.blockAccount = false;
        this.attemptsfailed = 0;
    }

    public boolean cheking (int pinInserted) {
        if (blockAccount) {
            return false;
        }
        if (pinInserted == pin) {
            return true;
        } else {
            attemptsfailed++;
            System.out.println("Incorrect pin. You have " + (3 - attemptsfailed) + " attempts left.");
            if (attemptsfailed >= 3) {
                blockAccount = true;
                System.out.println("Your account has been blocked.");
            }
            return false;
        }

    }
        
}
