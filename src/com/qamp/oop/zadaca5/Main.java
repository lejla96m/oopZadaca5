package com.qamp.oop.zadaca5;

public class Main {
    public static void main(String[] args) {

        ATM atm = new ATM();

        Account currentAccount = new CurrentAccount("Stephanie", "Germanotta", "77th Avenue, NYC", "SNSG123", 4444, 5000);

        atm.addAccount(currentAccount);

        System.out.println(atm.showAccountState("SNSG123", 4444));

        atm.withdraw(500,"SNSG123",4444);

        System.out.println(atm.showAccountState("SNSG123",4444));

        atm.depositMoney(1000,"SNSG123",4444);

        System.out.println(atm.showAccountState("SNSG123",4444));

        SavingsAccount savingsAccount = new SavingsAccount("John", "Lennon", "Manhattan 54th Str.", "SNJL456", 5555,10000);

        atm.addAccount(savingsAccount);

        System.out.println(atm.showAccountState("SNJL456", 5555));

        atm.withdraw(100, "SNJL456", 5555);

        atm.withdraw(300,"SNJL456", 5555);

        System.out.println(atm.showAccountState("SNJL456", 5555));

        atm.depositMoney(500, "SNJL456", 5555);

        System.out.println(atm.showAccountState("SNJL456", 5555));

        atm.reset("SNJL456", 5555);

        System.out.println(atm.showAccountState("SNJL456", 5555));

        SavingsAccount savingsAccount1 = new SavingsAccount("Arthur", "Morgan", "308 Negra Arroyo Lane", "SNAM789", 1234, 2000, 500);

        atm.addAccount(savingsAccount1);

        System.out.println(atm.showAccountState("SNAM789", 1234));
    }
}
