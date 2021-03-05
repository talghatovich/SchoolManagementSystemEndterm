package com.company.repositories.interfaces;

import com.company.entities.*;

import java.util.List;

public interface IStudentRepository {
    Group getGroupInformation(Student student);
    List<Subject> getSubjectsInformation(Student student);
    List<Homework> getHomeworkOfSubject(Student student, String subjectName);

    List<Lesson> getLessonsInformation(Student student, String subjectName);
}
