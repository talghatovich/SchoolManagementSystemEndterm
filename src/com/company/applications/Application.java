package com.company;

import com.company.controllers.UserController;
import com.company.entities.Parent;
import com.company.entities.Student;
import com.company.entities.Teacher;
import com.company.entities.User;
import com.company.repositories.ParentRepository;
import com.company.repositories.StudentRepository;
import com.company.repositories.UserRepository;
import com.company.repositories.interfaces.IUserRepository;

import java.util.Scanner;

public class Application {
    private final UserController controller;
    private final Scanner scanner;

    public Application(UserRepository repository){
        this.controller = new UserController(repository);
        this.scanner = new Scanner(System.in);
    }

    public void run(){
        System.out.println("=====Log in like=====");
        System.out.println("|\t1. Student\t|");
        System.out.println("|\t2. Teacher\t|");
        System.out.println("|\t3. Parent \t|");
        System.out.println("|\t0. Exit   \t|");
        System.out.print("Enter option(0-3): ");
        switch (scanner.nextInt()){
            case 1 -> {
                System.out.print("Enter login: ");
                String login = scanner.next();
                System.out.print("Enter password: ");
                String password = scanner.next();
                Student student = this.controller.loginStudent(login, password);
                if(student != null){
                    StudentApplication studentApplication = new StudentApplication(new StudentRepository(this.controller.getDataBase()),student);
                    studentApplication.run();
                } else{
                    System.out.println("Permission denied");
                }
            }
//            case 2 -> {
//                System.out.print("Enter login: ");
//                String login = scanner.next();
//                System.out.println("Enter password");
//                String password = scanner.next();
//                Teacher teacher = this.controller.loginTeacher(login, password);
//                if(teacher != null){
//                }
//            }
            case 3 -> {
                System.out.print("Enter login: ");
                String login = scanner.next();
                System.out.print("Enter password: ");
                String password = scanner.next();
                Parent parent = this.controller.loginParent(login, password);
                if(parent != null){
                    ParentApplication parentApplication = new ParentApplication(this.controller.getDataBase(), parent);
                    parentApplication.run();
                } else{
                    System.out.println("Permission denied");
                }
            }
        }
    }
}
