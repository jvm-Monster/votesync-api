package com.vi.votesyncapi.daointerfaces;

import com.vi.votesyncapi.model.Student;

/**
 * DAO for {@link Student}
 */
public interface StudentDao {
    //Sets of Operations
    Student getStudent(String studentId);
    void addStudent(Student student);//add student
    void removeStudent(String studentId);//remove student
    void updateStudent(Student student);//update student

}
