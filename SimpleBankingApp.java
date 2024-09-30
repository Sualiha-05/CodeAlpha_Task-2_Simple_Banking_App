/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankingApp;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Ismail
 */
public class SimpleBankingApp {
    private static double balance = 0.0;
    private static final int MAX_TRANSACTIONS = 100;
    private static Transaction[] transactionHistory = new Transaction[MAX_TRANSACTIONS];
    private static int transactionCount = 0;

    
    // ANSI escape codes for color
    private static final String RESET = "\033[0m"; // Reset to default color
    private static final String GREEN = "\033[32m"; // Green color
    private static final String RED = "\033[31m"; // Red color

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("****************************************************");
        System.out.println("* Welcome to the Simple Banking Application! *");
        System.out.println("****************************************************");

        while (running) {
            System.out.println("\n****************************************************");
            System.out.println("* Choose an operation: *");
            System.out.println("****************************************************");
            System.out.println("* 1. Deposit Money *");
            System.out.println("* 2. Withdraw Money *");
            System.out.println("* 3. Check Balance *");
            System.out.println("* 4. View Transaction History *");
            System.out.println("* 5. Exit *");
            System.out.println("****************************************************");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    deposit(scanner);
                    break;
                case 2:
                    withdraw(scanner);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    viewTransactionHistory();
                    break;
                case 5:
                    System.out.println(GREEN + "****************************************************" + RESET);
                    System.out.println(GREEN + "* Thank you for using the Simple Banking Application. *" + RESET);
                    System.out.println(GREEN + "****************************************************" + RESET);
                    running = false;
                    break;
                default:
                    System.out.println(RED + "****************************************************" + RESET);
                    System.out.println(RED + "* Invalid choice. Please choose again. *" + RESET);
                    System.out.println(RED + "****************************************************" + RESET);
            }
        }
        scanner.close();
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.println(GREEN + "You have successfully deposited $" + amount + RESET);

            if (transactionCount < MAX_TRANSACTIONS) {
                transactionHistory[transactionCount++] = new Transaction("Deposit", amount, new Date(), "Deposit to account");
            } else {
                System.out.println(RED + "Transaction history is full. Cannot record more transactions." + RESET);
            }
        } else {
            System.out.println(RED + "Invalid amount. Please enter a positive number." + RESET);
        }
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(GREEN + "You have successfully withdrawn $" + amount + RESET);

            if (transactionCount < MAX_TRANSACTIONS) {
                transactionHistory[transactionCount++] = new Transaction("Withdrawal", amount, new Date(), "Withdrawal from account");
            } else {
                System.out.println(RED + "Transaction history is full. Cannot record more transactions." + RESET);
            }
        } else if (amount > balance) {
            System.out.println(RED + "Insufficient balance. You only have $" + balance + RESET);
        } else {
            System.out.println(RED + "Invalid amount. Please enter a positive number." + RESET);
        }
    }

    private static void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    private static void viewTransactionHistory() {
        if (transactionCount == 0) {

            System.out.println(RED + "No transactions found." + RESET);

        } else {
            System.out.println(GREEN + "****************************************************" + RESET);
            System.out.println("Transaction History:");
            System.out.println(GREEN + "****************************************************" + RESET);
            for (int i = 0; i < transactionCount; i++) {
                System.out.println("Transaction #" + (i + 1));
                System.out.println(transactionHistory[i]);
                System.out.println(); // Add an extra line for better readability between transactions
            }
        }
    }
}

