package com.vi.votesyncapi.dao;

import com.vi.votesyncapi.daointerfaces.ElectionDao;
import com.vi.votesyncapi.model.Election;
import com.vi.votesyncapi.model.ElectionType;
import com.vi.votesyncapi.util.DatabaseManager;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ElectionDaoImpl implements ElectionDao {

    @Override
    public List<Election> getElections(String schoolId) {
       DatabaseManager databaseManager = new DatabaseManager();
       return databaseManager.executeInTransaction(() -> {
           TypedQuery<Election> typedQuery = databaseManager.entityManager.createQuery(
                   "SELECT e FROM Election e where" +
                           " e.school.schoolId=:schoolId or e.school.schoolName=:schoolName", Election.class
           );
           typedQuery.setParameter("schoolId",schoolId);
           typedQuery.setParameter("schoolName",schoolId);
           return typedQuery.getResultList();

       },"ds");


    }


    @Override
    public void addElection(Election election) {

    }

    @Override
    public void removeElection(Election election) {

    }

    @Override
    public void updateElection(Election election) {

    }
}
