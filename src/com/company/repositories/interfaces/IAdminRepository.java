package com.company.repositories.interfaces;

import com.company.entities.*;

public interface IAdminRepository {

    boolean addTeacher(Teacher teacher);
    boolean deleteTeacher(int id);

    boolean addStudent(Student student);
    boolean deleteStudent(int id);

    boolean addClass(Group group);
    boolean deleteClass(int id);

    boolean addParent(Parent parent);
    boolean deleteParent(int id);

}
