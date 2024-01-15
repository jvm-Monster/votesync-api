package com.vi.votesyncapi.daointerfaces;

import com.vi.votesyncapi.model.Candidate;
import com.vi.votesyncapi.model.Vote;

import java.util.List;

public interface VoteDao {

    void createVote(Vote vote);
    long getVotesForElection(String schoolId,String electionType,String electionName);
    Vote getStudentVotes(String studentId, String schoolId,String electionType,String electionName);

}
