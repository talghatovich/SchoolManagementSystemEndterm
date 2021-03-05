package com.company.repositories.interfaces;

import com.company.entities.Parent;
import com.company.entities.Student;
import com.company.entities.Teacher;

public interface IUserRepository {
    Student loginStudent(String login, String password);
//    Teacher loginTeacher(String login, String password);
//    Parent loginParent(String login, String password);
}
