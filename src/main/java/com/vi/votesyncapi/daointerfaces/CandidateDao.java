package com.vi.votesyncapi.daointerfaces;

import com.vi.votesyncapi.beanparamresources.CandidateBeanQueryParam;
import com.vi.votesyncapi.model.Candidate;
import com.vi.votesyncapi.model.Student;

import java.util.List;

/**
 * DAO for {@link Candidate}
 */
public interface CandidateDao {
    void addCandidate(Candidate candidate);// add new candidate
    Candidate getCandidate(int candidateId);
    List<Candidate> getCandidates();
    void removeCandidate(int candidate);// remove candidate
    void updateCandidate(Candidate candidate);// update candidate
    List<Candidate> getCandidateOnQueryParam(CandidateBeanQueryParam candidateBeanQueryParam);
}
