package com.company.entities;

public class Parent extends User {
    public Parent(){
    }

    public Parent(String firstName, String lastName, boolean gender, String address, String dateOfBirth) {
        super(firstName, lastName, gender, address, dateOfBirth);
    }

    public Parent(int id, String firstName, String lastName, boolean gender, String address, String dateOfBirth) {
        super(id, firstName, lastName, gender, address, dateOfBirth);
    }
}
