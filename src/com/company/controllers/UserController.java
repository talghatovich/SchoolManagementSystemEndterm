package com.company.controllers;

import com.company.database.interfaces.IDB;
import com.company.entities.Parent;
import com.company.entities.Student;
import com.company.entities.Teacher;
import com.company.repositories.UserRepository;
import com.company.repositories.interfaces.IUserRepository;

public class UserController {
    private final UserRepository repository;

    public UserController(UserRepository repository){
        this.repository = repository;
    }

    public IDB getDataBase(){
        return repository.getDb();
    }

    public Student loginStudent(String login, String password){
        return repository.loginStudent(login, password);
    }

//    public Teacher loginTeacher(String login, String password){
//        return repository.loginTeacher(login, password);
//    }
//
    public Parent loginParent(String login, String password){
        return repository.loginParent(login, password);
    }

}
