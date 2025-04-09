package com.atmv2;
import java.util.Scanner;
import models.Account;

public class ATMV2 {
    private Account account;
    private transactionhistory records;
    private MoneyAmount moneyAmount;
    private Scanner scanner;

    final String RESET = "\u001B[0m";
    final String GREEN = "\u001B[32m";
    final String RED = "\u001B[31m";
    final String WHITE = "\u001B[97m";
    
    public ATMV2() {
        this.account = new Account(1234);
        this.moneyAmount = new MoneyAmount(50000);
        this.records = new transactionhistory();
        this.scanner = new Scanner (System.in);

    }

    public void runAtm() {
        System.out.println(GREEN + "Welcome to the ATM!" + RESET);
        if (!chekingUser()) {
            return;
        }

        int choice ;
        do {
            showMenu();
            choice = scanner.nextInt();
            processChoice (choice);

        } while (choice != 6);
        scanner.close();
    }
        
        private boolean chekingUser() {
            int attempts = 0;
            while (attempts < 3) {
                System.out.println("Enter your PIN: ");
                int pinInserted = scanner.nextInt();
                if (account.cheking(pinInserted)) {
                    return true;
            }
            attempts++;            
        }
        return false;
          
    }

    private void showMenu() {
        System.out.println("Choose an option");
        System.out.println("1. Cheking money");
        System.out.println("2. Add noney to your own account");
        System.out.println("3. Withdraw money");
        System.out.println("4. Deposit money");
        System.out.println("5. Watch transaction history");
        System.out.println("6. Exit");
        System.out.println("7. ???");
        System.out.println("Waiting for your answer:");
    }

    private void processChoice (int choice) {
        switch (choice) {
            case 1:
            System.out.println(GREEN + "You have " + moneyAmount.getAmount() + " dollars" + RESET); 
                break;

            case 2:
            System.out.println("Write the amount you want add to your account:");
            double addAmount = scanner.nextInt();
            moneyAmount.addMoneytoAccount(addAmount);
            System.out.println(GREEN + "You have deposited "+ addAmount + " dollars to your own account" + RESET);
            records.register(GREEN + "You added " + addAmount + " dollars to your account" + RESET);
            break;

            case 3:
            System.out.println("Write the amount you want to withdraw:");
            double amount = scanner.nextDouble();
            if (moneyAmount.withdrawMoney(amount)) {
                System.out.println(GREEN + "Withdrawal successful!" + RESET);
                records.register(GREEN + "Withdraw of " + amount + " dollars" + RESET);
            }
            break;

            case 4:
            System.out.println("Write the amount you want to deposit:");
            double deposit = scanner.nextDouble();
            moneyAmount.depositeMoney(deposit);
            System.out.println(GREEN + "Deposite done!" + RESET);
            records.register (GREEN + "Deposite of " + deposit + " dollars" + RESET);
            break;

            case 5:
            System.out.println("Transaction history");
            records.showhistory();
            break;

            case 6:
            System.out.println(GREEN + "Goodbye!" + RESET);
            System.out.println(GREEN + "Thanks for using my ATMV2! 8(^O^)8 " + RESET);
            System.exit(0);
            break;

            case 7:
            System.out.println(RED + "Your account has been hacked by DeadSec " + RESET);
            String[] calavera = {
                "       ______",
                "    .-'      `-.",
                "   /            \\",
                "  |              |",
                "  |,  .-.  .-.  ,|",
                "  | )(_o/  \\o_)( |",
                "  |/     /\\     \\|",
                "  (_     ^^     _)",
                "   \\__|IIIIII|__/",
                "    | \\IIIIII/ |",
                "    \\          /",
                "     `--------`"
                };
                for (String line : calavera) {
                    System.out.println(WHITE + line + RESET);
                }
                break;

            default:
            System.out.println("Invalid option. Please choose a valid option.");
                break;
        }
    }
    
}
