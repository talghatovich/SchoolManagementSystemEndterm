package com.company.entities;

public class Teacher extends User{
    private int salary;

    public Teacher(){
    }

    public Teacher(String firstName, String lastName){
        super(firstName, lastName);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
