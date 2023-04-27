package com.qamp.oop.zadaca5;

public class Owner {

    private final String firstName;
    private final String lastName;
    private final String address;

    public Owner(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String ownerToString () {
        return getFirstName() + ", " + getLastName() + ", " + getAddress();
    }
}
