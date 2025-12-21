/*Design a console-based Bank Management Program in Java that allows a user to create a
bank account and perform basic banking operations such as deposit, withdrawal, balance
enquiry, and account details display. The program should handle exceptions as required. */

import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private String accountHolderName;
    private int accountNumber;
    private double balance;

    public BankAccount(String name, int accNo, double initialBalance) {
        accountHolderName = name;
        accountNumber = accNo;
        balance = initialBalance;
    }

    public void deposit(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
        System.out.println("Amount deposited successfully.");
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance.");
        }
        balance -= amount;
        System.out.println("Amount withdrawn successfully.");
    }

    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void displayDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Number     : " + accountNumber);
        System.out.println("Balance            : ₹" + balance);
    }
}


public class Prob5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Account Creation
        System.out.println("=== Create Bank Account ===");
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        BankAccount account = new BankAccount(name, accNo, balance);

        int choice;
        do {
            System.out.println("\n=== Bank Menu ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Enquiry");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = sc.nextDouble();
                        account.deposit(depositAmount);
                        break;

                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = sc.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;

                    case 3:
                        account.checkBalance();
                        break;

                    case 4:
                        account.displayDetails();
                        break;

                    case 5:
                        System.out.println("Thank you for using Bank Management System.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (IllegalArgumentException | InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 5);

    }
}
