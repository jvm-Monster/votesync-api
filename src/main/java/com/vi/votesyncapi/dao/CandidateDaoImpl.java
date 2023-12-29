package com.vi.votesyncapi.dao;

import com.vi.votesyncapi.daointerfaces.CandidateDao;
import com.vi.votesyncapi.model.Candidate;
import com.vi.votesyncapi.model.ElectionType;
import com.vi.votesyncapi.model.School;
import com.vi.votesyncapi.util.DatabaseManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CandidateDaoImpl implements CandidateDao {
    final DatabaseManager databaseManager = new DatabaseManager();
    @Override
    public void addCandidate(Candidate candidate) {
        databaseManager.executeInTransaction(()->{
            candidate.setCandidateId(generateCandidateId(candidate));
            databaseManager.entityManager.persist(candidate);
        },"An error Occurred!");
    }

    @Override
    public Candidate getCandidate(int candidateId) {
        return databaseManager.executeInTransaction(()->{
            return databaseManager.entityManager.find(Candidate.class,candidateId);
        },"Error getting Candidate");
    }

    @Override
    public List<Candidate> getCandidates() {
        return databaseManager.executeInTransaction(()->{
            TypedQuery<Candidate> typedQuery = databaseManager.entityManager.createQuery(
                    "SELECT c FROM Candidate c", Candidate.class
            );
            return typedQuery.getResultList();
        },"Error getting Candidate");
    }


    @Override
    public void removeCandidate(int candidateId) {
        databaseManager.executeInTransaction(() -> {
            Candidate removeCandidate = databaseManager.entityManager.find(Candidate.class,candidateId);
            if(removeCandidate!=null) {
                databaseManager.entityManager.remove(removeCandidate);
            }
        },"");
    }

    @Override
    public void updateCandidate(Candidate candidate) {
        databaseManager.executeInTransaction(()->{
            Candidate candidateEntity = databaseManager.entityManager.find(Candidate.class,candidate.getCandidateId());
            if(candidateEntity!=null){
               candidateEntity.setSchool(candidate.getSchool());
               candidateEntity.setElection(candidate.getElection());
            }
        },"");
    }

    // Method to generate custom candidateId
    private int generateCandidateId(Candidate candidate) {
        // Logic to generate a unique candidateId based on school abbreviation and election type
        // You can use a combination of these values to create a unique ID
        // For simplicity, you can modify this logic based on your specific requirements
        String customId = candidate.getStudent().getStudentId()+"_"+candidate.getSchool().getSchoolId() + "_" +
                candidate.getElection().getElectionType()+"_"+candidate.getElection().getElectionName();
        // Convert the customId to an integer, you can use a more sophisticated logic if needed
        return customId.hashCode();
    }
}
