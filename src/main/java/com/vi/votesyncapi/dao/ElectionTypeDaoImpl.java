package com.vi.votesyncapi.dao;

import com.vi.votesyncapi.daointerfaces.ElectionTypeDao;
import com.vi.votesyncapi.model.ElectionType;
import com.vi.votesyncapi.util.DatabaseManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ElectionTypeDaoImpl implements ElectionTypeDao {
    @Override
    public List<ElectionType> getElections(String schoolId,String electionType) {
        DatabaseManager databaseManager = new DatabaseManager();
        System.out.println(schoolId);
        return databaseManager.executeInTransaction(() -> {
            TypedQuery<ElectionType> typedQuery = databaseManager.entityManager.createQuery(
                     "SELECT e FROM ElectionType e WHERE e.school.schoolId = :schoolId or e.electionType = :electionType", ElectionType.class
            );

            /*typedQuery.setParameter("schoolId",school);*/
            typedQuery.setParameter("schoolId",schoolId);
            typedQuery.setParameter("electionType",electionType);
            List<ElectionType> elections = typedQuery.getResultList();
            elections.forEach(election -> {
                if (election.getElections() != null) {
                    election.getElections().size();
                }
            });

            return elections;
            // Initialize the collections before returning



        }, "ds");
    }

}
