package com.vi.votesyncapi.dto;

import com.vi.votesyncapi.model.Candidate;
import com.vi.votesyncapi.model.Election;
import com.vi.votesyncapi.model.School;
import com.vi.votesyncapi.model.Student;


public record VoteDto(String voteId, boolean voted, Student student, School school, Candidate candidate,
                      Election election) {
}
