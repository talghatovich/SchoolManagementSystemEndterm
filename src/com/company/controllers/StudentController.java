package com.company.controllers;

import com.company.entities.*;
import com.company.repositories.interfaces.IStudentRepository;

import java.util.List;

public class StudentController {
    private final IStudentRepository studentRepository;

    public StudentController(IStudentRepository studentRepository) { this.studentRepository = studentRepository;}

    public String getGroupInformation(Student student){
        Group group = studentRepository.getGroupInformation(student);
        StringBuilder result = new StringBuilder("=====================================================");
        result.append("\nFirst name\t\tLast name\nTeacher\n").append(group.getTeacher().getFirstName()).append("\t\t\t").append(group.getTeacher().getLastName()).append("\n");
        for(Student _student : group.getStudentList()){
            result.append(_student.getFirstName()).append("\t\t\t").append(_student.getLastName()).append("\n");
        }
        result.append("=====================================================\n");
        return result.toString();
    }

    public String getSubjectsInfo(Student student){
        List<Subject> subjects = studentRepository.getSubjectsInformation(student);
        StringBuilder result = new StringBuilder();
        result.append("Subject name\t\tTeacher\t\t\tDay\t\tStart time\t\tEnd time\n");
        for(Subject subject: subjects){
            result.append(subject.getSubjectName()).append("\t\t").append(subject.getTeacherFirstName()).append(" ").append(subject.getTeacherLastName()).append("\t\t\t").append(subject.getDay()).append("\t\t").append(subject.getStartTime()).append("\t\t").append(subject.getEndTime()).append("\n");
        }
        return result.toString();
    }

    public String getHomeworkOfSubject(Student student, String subjectName){
        List<Homework> homeworks = studentRepository.getHomeworkOfSubject(student, subjectName);
        StringBuilder result = new StringBuilder();
        result.append("Description\t\tDeadline\n");
        for(Homework homework : homeworks){
            result.append(homework.getDescription()).append("\t\t").append(homework.getDeadline()).append("\n");
        }
        return result.toString();
    }

    public String getLessonsInformation(Student student, String subjectName){
        List<Lesson> lessons = studentRepository.getLessonsInformation(student, subjectName);
        StringBuilder result = new StringBuilder("Date\t\tPresent\t\tMark\n");
        for(Lesson lesson: lessons){
            result.append(lesson.getDate()).append("\t\t").append(lesson.isPresent()).append("\t\t").append(lesson.getMark()).append("\n");
        }
        return result.toString();
    }

}
