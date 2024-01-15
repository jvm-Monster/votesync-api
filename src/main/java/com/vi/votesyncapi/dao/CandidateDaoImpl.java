package com.vi.votesyncapi.dao;

import com.vi.votesyncapi.beanparamresources.CandidateBeanQueryParam;
import com.vi.votesyncapi.daointerfaces.CandidateDao;
import com.vi.votesyncapi.model.Candidate;
import com.vi.votesyncapi.model.Student;
import com.vi.votesyncapi.util.DatabaseManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
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

    @Override
    public List<Candidate> getCandidateOnQueryParam(CandidateBeanQueryParam candidateBeanQueryParam) {
        String school = candidateBeanQueryParam.getSchool();
        String electionType = candidateBeanQueryParam.getElectionType();
        String electionName = candidateBeanQueryParam.getElectionName();

        return databaseManager.executeInTransaction(() -> {
            TypedQuery<Candidate> candidates = databaseManager.entityManager.createQuery(
                    "SELECT c " +
                            "FROM Candidate c " +
                            "WHERE c.school.schoolId = :schoolId " +
                            "AND c.election.electionType=:electionType " +
                            "AND c.election.electionName=:electionName",
                    Candidate.class
            );

            candidates.setParameter("schoolId", school);
            candidates.setParameter("electionType",electionType);
            candidates.setParameter("electionName",electionName);

            System.out.println("Result: " + candidates.getResultList());

            return candidates.getResultList();
        }, "Error getting Candidate");
    }
    /*Query query = databaseManager.entityManager.createQuery(
            "SELECT c.candidateId,c.student.studentName FROM Candidate c " +
                    " WHERE c.school.schoolId=:schoolId and c.election.electionType=:electType and c.election.electionName=:electName"
            ,Object[].class);
            query.setParameter("schoolId",school);
            query.setParameter("electType",electionType);
            query.setParameter("electName",electionName);

    List<Object[]> r= query.getResultList();
    List<Candidate> candidateList = new ArrayList<>();
            for (Object[] or:r) {
        Candidate candidate = new Candidate();
        candidate.setCandidateId((Long)or[0]);
        Student student = new Student();
        student.setStudentName((String)or[1]);
        candidate.setStudent(student);
        candidateList.add(candidate);
    }
            return candidateList;
*/

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
