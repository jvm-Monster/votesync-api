package com.vi.votesyncapi.daointerfaces;

import com.vi.votesyncapi.model.School;
import com.vi.votesyncapi.model.Student;

import java.util.List;

/**
 * DAO for {@link School}
 */
public interface SchoolDao {
    // Sets of Operations
    List<School> retrieveAllSchool();
    School retrieveSchool(String schoolId);
    void addSchool(School school);//add school
    void removeSchool(String schoolId);
    void updateSchool(School school);
}
