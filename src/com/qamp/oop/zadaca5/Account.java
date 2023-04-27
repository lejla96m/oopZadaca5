package com.qamp.oop.zadaca5;

public abstract class Account extends Owner {

    private final String serialNumber;
    private final int passcode;
    private double balance;

    public Account(String firstName, String lastName, String address, String serialNumber, int passcode, double balance) {
        super(firstName, lastName, address);
        this.serialNumber = serialNumber;
        this.passcode = passcode;
        this.balance = balance;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean checkPasscode(int passcode) {
        return this.passcode == passcode;
    }

    public abstract double deposit (double amount);

    public abstract double withdraw (double amount);
}
