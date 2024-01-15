package com.vi.votesyncapi.dao;

import com.vi.votesyncapi.daointerfaces.VoteDao;
import com.vi.votesyncapi.dto.ElectionDto;
import com.vi.votesyncapi.exception.DatabaseConnectionException;
import com.vi.votesyncapi.model.Candidate;
import com.vi.votesyncapi.model.Election;
import com.vi.votesyncapi.model.Vote;
import com.vi.votesyncapi.util.DatabaseManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class VoteDaoImpl implements VoteDao {
    final DatabaseManager databaseManager;
    public VoteDaoImpl(DatabaseManager databaseManager){
        this.databaseManager=databaseManager;
    }
    @Override
    public void createVote(Vote vote) {
        try{
            databaseManager.executeInTransaction(() -> {
                databaseManager.entityManager.persist(vote);
            },"Error Occurred on the Database End");
        }catch (Exception e){
            System.out.println("printing voting exception : "+ e);
        }
    }

    @Override
    public long getVotesForElection(String schoolId,String electionType, String electionName) {
        try{
            return databaseManager.executeInTransaction(() -> {
                TypedQuery<Long> query = databaseManager.entityManager
                        .createQuery(
                                "SELECT COUNT(v) " +
                                        "FROM Vote v WHERE v.election.school.schoolId = :schoolId AND " +
                                        "v.election.electionType = :electionType " +
                                        "AND v.election.electionName = :electionName",Long.class
                        );

                query.setParameter("schoolId",schoolId);
                query.setParameter("electionType",electionType);
                query.setParameter("electionName",electionName);


                // Execute the query and return the result
                return query.getSingleResult();
            },"Error Occurred on the Database End");
        }catch (Exception e){
            throw new DatabaseConnectionException("Transaction not successfully");
        }
    }
    @Override
    public  Vote getStudentVotes(String studentId,String schoolId,String electionType,String electionName){
        try{
            return databaseManager.executeInTransaction(() -> {
                TypedQuery<Vote> query = databaseManager.entityManager
                        .createQuery(
                                "SELECT v " +
                                        "FROM Vote v WHERE v.election.school.schoolId = :schoolId " +
                                        "AND v.student.studentId = :studentId " +
                                        "AND v.election.electionType = : electionType " +
                                        "AND v.election.electionName = : electionName", Vote.class
                        );

                query.setParameter("studentId",studentId);
                query.setParameter("schoolId",schoolId);
                query.setParameter("electionType",electionType);
                query.setParameter("electionName",electionName);

                // Execute the query and return the result
                return query.getSingleResult();
            },"Error Occurred on the Database End");
        }catch (Exception e){
            throw new DatabaseConnectionException("Transaction not successfully");
        }
    }
}
