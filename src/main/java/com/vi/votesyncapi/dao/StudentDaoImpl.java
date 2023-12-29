package com.vi.votesyncapi.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vi.votesyncapi.daointerfaces.StudentDao;
import com.vi.votesyncapi.exception.DatabaseConnectionException;
import com.vi.votesyncapi.model.Student;
import com.vi.votesyncapi.util.ConvertToUpperCaseUtil;
import com.vi.votesyncapi.util.DatabaseManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import javax.management.Query;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public class StudentDaoImpl implements StudentDao {

    @Override
    public Student getStudent(String studentId) {
        DatabaseManager databaseManager = new DatabaseManager();
        final Student[] studentEntity = {null};

        try {
            databaseManager.executeInTransaction(() -> {
                studentEntity[0] = databaseManager.entityManager.find(Student.class, studentId);
            }, "Could not retrieve student");
        } catch (Exception e) {
            throw new DatabaseConnectionException("Error while retrieving student", e);
        }

        if (studentEntity[0] != null) {
            return studentEntity[0];
        } else {
            // Optionally return null instead of throwing an exception
            // throw new RuntimeException("Student not found");
            return null;
        }
    }

    @Override
    public void addStudent(Student student) {
        DatabaseManager databaseManager = new DatabaseManager();

        String toUpperCase = ConvertToUpperCaseUtil.convertToUpperCase(student.getStudentId());
        student.setStudentId(toUpperCase);

        databaseManager.executeInTransaction(() -> {
            databaseManager.entityManager.persist(student);
        },"Could not add student");
    }

    @Override
    public void removeStudent(String studentId) {
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.executeInTransaction(() -> {
            Student studentEntity = databaseManager.entityManager.find(Student.class,studentId);
            if(studentEntity!=null){
                databaseManager.entityManager.remove(studentEntity);
            }

        },"Could not delete student");
    }

    @Override
    public void updateStudent(Student student) {
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.executeInTransaction(() -> {
            Student studentEntity = databaseManager.entityManager.find(Student.class, student.getStudentId());
            if (studentEntity != null) {
                updateNonEmptyFields(student,studentEntity);
            }
            else{
                System.out.println("Could not update it");
            }
        },"Could not update student");
    }

    private void updateNonEmptyFields(Student source, Student target) {
        String studentId=source.getStudentId();
        String studentName=source.getStudentName();
        String studentEmail=source.getStudentEmail();
        String studentPassword=source.getStudentPassword();
        String school = source.getSchool().getSchoolId();

        if(studentName!=null&&!studentName.isEmpty()&&!studentName.equals(target.getStudentName())){
            target.setStudentName(source.getStudentName());
        }

        if(studentEmail!=null&&!studentEmail.isEmpty()&&!studentEmail.equals(target.getStudentEmail())){
            target.setStudentEmail(source.getStudentEmail());
        }


        if(studentPassword!=null&&!studentPassword.isEmpty()&&!studentPassword.equals(target.getStudentPassword())){
            target.setStudentPassword(source.getStudentPassword());
        }

        if(school!=null&&!school.isEmpty()&&!school.equals(target.getSchool().getSchoolId())){
            target.setSchool(source.getSchool());
        }




        // Add similar checks for other fields as needed
    }




}
