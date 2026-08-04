package oops;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// Code Example for Abstraction.

public final class BankAccount {
    // 1. PRIVATE FIELDS: Hidden from direct external modification
    private final String accountNumber;
    private double balance;
    private final List<String> transactionHistory;

    // 2. CONSTRUCTOR: Enforces valid initial state
    public BankAccount(String accountNumber, double initialDeposit) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be null or empty.");
        }
        if (initialDeposit < 0) {
            throw new IllegalArgumentException("Initial deposit cannot be negative.");
        }

        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
        this.transactionHistory = new ArrayList<>();
        this.transactionHistory.add("Account opened with balance: $" + initialDeposit);
    }

    // 3. READ-ONLY ACCESSORS (GETTERS)
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    //DEFENSING COPYING : This Prevents caller from changing the internal transaction history list directly
    public List<String> getTransactionHistory() {
        return Collections.unmodifiableList(transactionHistory);
    }

    // 4. CONTROLLED MUTATORS (BUSINESS METHODS INSTEAD OF NAKED SETTERS)

    public void deposit(double amount) {
        // Controlled mutation: Validation rule
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than 0.");
        }

        this.balance += amount;
        this.transactionHistory.add("Deposited: $" + amount + " | New Balance: $" + this.balance);
    }

    public void withdraw(double amount) {
        // Controlled mutation: Validation rule
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than 0.");
        }
        if (amount > balance) {
            throw new IllegalStateException("Insufficient funds. Current balance: $" + balance);
        }

        this.balance -= amount;
        this.transactionHistory.add("Withdrew: $" + amount + " | New Balance: $" + this.balance);
    }
}