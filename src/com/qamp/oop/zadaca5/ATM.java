package com.qamp.oop.zadaca5;

import java.util.ArrayList;
import java.util.List;

public class ATM {

    private final List<Account> accountRegister;

    public ATM () {
        this.accountRegister = new ArrayList<>();
    }

    public void addAccount(Account account) {
        this.accountRegister.add(account);
    }

    public double withdraw (double amount, String serialNumber, int passcode) throws IllegalStateException {
        validatePasscode(passcode);
        Account account = findAccount(serialNumber, passcode);
        account.withdraw(amount);
        return amount;
    }

    public double depositMoney (double amount, String serialNumber, int passcode) throws IllegalStateException {
        validatePasscode(passcode);
        Account account = findAccount(serialNumber, passcode);
        account.deposit(amount);
        return amount;
    }

    public void reset(String serialNumber, int passcode) throws IllegalStateException {
        validatePasscode(passcode);
        SavingsAccount savingsAccount = (SavingsAccount) findAccount(serialNumber, passcode);
        savingsAccount.reset();
    }

    public String showAccountState (String serialNumber, int passcode) throws IllegalStateException {
        validatePasscode(passcode);
        Account account = findAccount(serialNumber, passcode);
        String balanceInfo = "current balance: " + account.getBalance();
        if (account instanceof SavingsAccount) {
            SavingsAccount savingsAccount = (SavingsAccount) account;
            balanceInfo += ", current daily limit: " + (savingsAccount.getTransactionLimitAmount() - savingsAccount.getDailyWithdrawn())
                    + ", number of available transactions: " + (savingsAccount.getDailyTransactionLimit() - savingsAccount.getDailyTransactions());
        }
        return account.ownerToString() + ", " + balanceInfo;
    }

    private void validatePasscode (int passcode) {
        if (passcode < 1000 || passcode > 9999) {
            throw new IllegalArgumentException("Invalid passcode");
        }
    }

    private Account findAccount(String serialNumber, int passcode) throws IllegalStateException {
        for (Account account : accountRegister) {
            if (account.getSerialNumber().equals(serialNumber)) {
                if (account.checkPasscode(passcode)) {
                    return account;
                } else {
                    throw new IllegalStateException("Incorrect passcode for account with serial number " + serialNumber);
                }
            }
        }
        throw new IllegalStateException("Account with serial number " + serialNumber + " not found");
    }
}
