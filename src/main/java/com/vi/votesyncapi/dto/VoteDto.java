package com.vi.votesyncapi.dto;

import com.vi.votesyncapi.model.Candidate;
import com.vi.votesyncapi.model.Election;
import com.vi.votesyncapi.model.School;
import com.vi.votesyncapi.model.Student;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
public class VoteDto{

    private String voteId;
    private boolean voted;
    Student student;
    School school;
    Candidate candidate;
    Election election;
}
