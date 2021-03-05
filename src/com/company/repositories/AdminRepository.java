package com.company.repositories;

import com.company.database.interfaces.IDB;
import com.company.entities.*;
import com.company.entities.Group;
import com.company.repositories.interfaces.IAdminRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminRepository implements IAdminRepository {
    private final IDB db;

    public AdminRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        Connection con = null;
        try{
            con = db.getConnection();
            String sql = "INSERT INTO Teachers(firstName, lastName, gender, " +
                    "address, dateOfBirth, email, phone, salary,password ) " +
                    "VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, teacher.getFirstName());
            st.setString(2, teacher.getLastName());
            st.setBoolean(3,teacher.getGender());
            st.setString(4, teacher.getAddress());
            st.setString(5, teacher.getDateOfBirth());
            st.setString(6, teacher.getEmail());
            st.setString(7, teacher.getPhoneNumber());
            st.setInt(8, teacher.getSalary());
            st.setString(9, "123");

            return st.execute();

        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException sqlException) {
                System.out.println(sqlException.getMessage());
            }
        }
        return true;
    }

    @Override
    public boolean deleteTeacher(int id) {
        Connection con = null;
        try {
            con= db.getConnection();
            String sql = "DELETE FROM Teachers" +
                    "WHERE teacherId = ?";

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            return st.execute();

        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            try {
                con.close();
            } catch (SQLException sqlException) {
                System.out.println(sqlException.getMessage());
            }
        }
        return true;
    }

    @Override
    public boolean addStudent(Student student) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Students(firstName, lastName, gender, " +
                    "address, dateOfBirth, email, phone, classId,password ) " +
                    "VALUES(?,?,?,?,?,?,?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, student.getFirstName());
            st.setString(2, student.getLastName());
            st.setBoolean(3,student.getGender());
            st.setString(4, student.getAddress());
            st.setString(5, student.getDateOfBirth());
            st.setString(6, student.getEmail());
            st.setString(7, student.getPhoneNumber());
            st.setInt(8, student.getGroupId());
            st.setString(9, "123");

            boolean executed = st.execute();

            if (executed) {
                System.out.println("The student is added");
            } else {
                System.out.println("Student was not added");
            }


        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException sqlException) {
                System.out.println(sqlException.getMessage());
            }
        }
        return true;
    }

    @Override
    public boolean deleteStudent(int id) {
        Connection con = null;
        try {
            con= db.getConnection();
            String sql = "DELETE FROM Students" +
                    "WHERE studentId = ?";

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            return st.execute();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            try {
                con.close();
            } catch (SQLException sqlException) {
                System.out.println(sqlException.getMessage());
            }
        }
        return true;
    }

    @Override
    public boolean addClass(Group group) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Classes(classTeacherId, classNumber, classLetter) VALUES(?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, group.getTeacher().getId());
            st.setInt(2, group.getGroupNumber());
            st.setString(3, String.valueOf(group.getGroupLetter()));
            return st.execute();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally {
            try{
                con.close();
            } catch (SQLException sqlException){
                System.out.println(sqlException.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean deleteClass(int id) {
        Connection con = null;
        try {
            con= db.getConnection();
            String sql = "DELETE FROM Classes" +
                    "WHERE classId = ?";

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);;

            return st.execute();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            try {
                con.close();
            } catch (SQLException sqlException) {
                System.out.println(sqlException.getMessage());
            }
        }
        return true;
    }

    @Override
    public boolean addParent(Parent parent) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Parents(firstName, lastName, gender, address, dateOfBirth, email, phone, password)" +
                    "VALUES(?,?,?,?,?,?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, parent.getFirstName());
            st.setString(2, parent.getLastName());
            st.setBoolean(3, parent.getGender());
            st.setString(4, parent.getAddress());
            st.setString(5, parent.getDateOfBirth());
            st.setString(6, parent.getEmail());
            st.setString(7, parent.getPhoneNumber());
            st.setString(8, "123");

            return st.execute();

        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public boolean deleteParent(int id) {
        Connection con = null;
        try {
            con = db.getConnection();

            String sql = "DELETE FROM parents " +
                    "WHERE parentId = ?";

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            return st.execute();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            try {
                con.close();
            } catch (SQLException sqlException) {
                System.out.println(sqlException.getMessage());
            }
        }
        return true;
    }

}
