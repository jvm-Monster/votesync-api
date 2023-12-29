package com.vi.votesyncapi.dao;

import com.vi.votesyncapi.daointerfaces.SchoolDao;
import com.vi.votesyncapi.model.ElectionType;
import com.vi.votesyncapi.model.School;
import com.vi.votesyncapi.model.Student;
import com.vi.votesyncapi.util.DatabaseManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class SchoolDaoImpl implements SchoolDao {
    DatabaseManager databaseManager = new DatabaseManager();

    @Override
    public List<School> retrieveAllSchool(){

        return databaseManager.executeInTransaction(
                () -> {
                    TypedQuery<School> typedQuery = databaseManager.entityManager.createQuery(
                            "SELECT e FROM School e", School.class
                    );
                    return typedQuery.getResultList();
                },""
        );
    }
    @Override
    public School retrieveSchool(String schoolId){
        final School[] schoolEntity = {null};
        databaseManager.executeInTransaction(()->{
           schoolEntity[0] = databaseManager.entityManager.find(School.class,schoolId);
        },"An Error Occurred");
        if(schoolEntity[0]!=null){
            return schoolEntity[0];
        }else{
            throw new RuntimeException("Not Found");
        }
    }
    @Override
    public void addSchool(School school) {
        databaseManager.executeInTransaction(() -> {
            databaseManager.entityManager.persist(school);
        },"");
    }

    @Override
    public void removeSchool(String schoolId) {
        databaseManager.executeInTransaction(() -> {
            School removeSchool = databaseManager.entityManager.find(School.class,schoolId);
            if(removeSchool!=null) {
                databaseManager.entityManager.remove(removeSchool);
            }
        },"");
    }

    @Override
    public void updateSchool(School school) {
        databaseManager.executeInTransaction(()->{
            School schoolEntity = databaseManager.entityManager.find(School.class,school.getSchoolId());
            if(schoolEntity!=null){
                schoolEntity.setSchoolId(school.getSchoolId());
                schoolEntity.setSchoolName(school.getSchoolName());
                schoolEntity.setState(school.getState());
            }
        },"");
    }
}
