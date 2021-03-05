package com.company.applications;

import com.company.controllers.StudentController;
import com.company.database.interfaces.IDB;
import com.company.entities.Parent;
import com.company.entities.Student;
import com.company.repositories.ParentRepository;
import com.company.repositories.StudentRepository;
import com.company.repositories.interfaces.IStudentRepository;

import java.util.Scanner;

public class ParentApplication extends StudentApplication{

    private final Parent parent;

    public ParentApplication(IDB db, Parent parent){
        super(new StudentRepository(db) ,new ParentRepository(db).getChild(parent));
        this.parent = parent;
    }

    public void run() {
        System.out.println("Welcome " +  parent.getFirstName() + " " + parent.getLastName());
        boolean exit = true;
        while (exit) {
            System.out.println("--Select option: ---------------");
            System.out.println("|\t1. Get child information       |");
            System.out.println("|\t2. Get schedule             |");
            System.out.println("|\t3. Get marks of subject     |");
            System.out.println("|\t4. Get homework of subject  |");
            System.out.println("|\t0. Exit                     |");
            System.out.println("--------------------------------");
            System.out.print("| Select option(0-4): ");
            switch (scanner.nextInt()) {
                case 1 -> {
                    this.getInformation();
                }
                case 2 -> {
                    this.getSubjectsInfo();
                }
                case 3 -> {
                    this.getMarkOfSubject();
                }
                case 4 -> {
                    this.getHomeworkOfSubject();
                }
                case 0 -> {
                    exit = false;
                }
                default -> {
                    System.out.println("WRONG INPUT");
                }
            }
        }
        System.out.println("Good bye " + parent.getFirstName() + " " + parent.getLastName());
    }
}
