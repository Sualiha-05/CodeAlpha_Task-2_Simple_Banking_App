/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankingApp;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Ismail
 */

// Transaction class to represent individual transactions
class Transaction {
    private String type;
    private double amount;
    private Date date;
    private String description;

    public Transaction(String type, double amount, Date date, String description) {
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
        return "Transaction Type: " + type + "\n" +
               "Amount: $" + amount + "\n" +
               "Date: " + sdf.format(date) + "\n" +
               "Description: " + description;
    }
}

