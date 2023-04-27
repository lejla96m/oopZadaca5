package com.qamp.oop.zadaca5;

public class CurrentAccount extends Account {

    public CurrentAccount (String firstName, String lastName, String address, String serialNumber, int passcode, double balance) {
        super(firstName, lastName, address, serialNumber, passcode, balance);
    }

    @Override
    public double withdraw (double amount) {
        double newBalance = getBalance() - amount;
        setBalance(newBalance);
        return newBalance;
    }

    @Override
    public double deposit (double amount) {
        double newBalance = getBalance() + amount;
        setBalance(newBalance);
        return newBalance;
    }

    public void reset() {
        // Do nothing
    }
}
