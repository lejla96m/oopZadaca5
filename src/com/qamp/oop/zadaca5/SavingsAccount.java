package com.qamp.oop.zadaca5;

public class SavingsAccount extends Account {

    private final int transactionLimitAmount;
    private final int dailyTransactionLimit = 3;
    private int dailyTransactions = 0;
    private double dailyWithdrawn = 0;

    public SavingsAccount (String firstName, String lastName, String address, String serialNumber, int passcode, double balance, int transactionLimitAmount) {
        super(firstName, lastName, address, serialNumber, passcode, balance);
        this.transactionLimitAmount = transactionLimitAmount;
    }

    public SavingsAccount (String firstName, String lastName, String address, String serialNumber, int passcode, double balance) {
        super(firstName, lastName, address, serialNumber, passcode, balance);
        this.transactionLimitAmount = 1000;
    }

    public int getTransactionLimitAmount () {
        return transactionLimitAmount;
    }

    public int getDailyTransactionLimit() {
        return dailyTransactionLimit;
    }

    public int getDailyTransactions() {
        return dailyTransactions;
    }

    public double getDailyWithdrawn () {
        return dailyWithdrawn;
    }

    public void setDailyWithdrawn(double dailyWithdrawn) {
        this.dailyWithdrawn = dailyWithdrawn;
    }

    @Override
    public double withdraw (double amount) throws IllegalStateException {
        if (getBalance() < 0) {
            throw new IllegalArgumentException("There is no available money on your account.");
        }
        if (getBalance() - amount < 0) {
            throw new IllegalStateException("Cannot withdraw more than the available balance");
        }
        if (dailyTransactions >= dailyTransactionLimit) {
            throw new IllegalStateException("Daily transaction limit exceeded");
        }
        if (dailyWithdrawn + amount > transactionLimitAmount) {
            throw new IllegalStateException("Daily withdrawal limit exceeded");
        }

        dailyTransactions++;

        double newDailyWithdrawn = dailyWithdrawn + amount;
        setDailyWithdrawn(newDailyWithdrawn);

        double newBalance = getBalance() - amount;
        setBalance(newBalance);
        return newBalance;
    }

    @Override
    public double deposit(double amount) throws IllegalStateException {
        if (dailyTransactions >= dailyTransactionLimit) {
            throw new IllegalStateException("Daily transaction limit exceeded");
        }

        dailyTransactions++;

        double newBalance = getBalance() + amount;
        setBalance(newBalance);
        return newBalance;
    }

    public void reset() {
        dailyTransactions = 0;
        dailyWithdrawn = 0;
    }
}
