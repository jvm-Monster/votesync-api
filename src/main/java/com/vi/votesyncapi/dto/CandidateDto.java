package com.vi.votesyncapi.dto;

import com.vi.votesyncapi.model.Candidate;
import com.vi.votesyncapi.model.Election;
import com.vi.votesyncapi.model.School;
import com.vi.votesyncapi.model.Student;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * DTO for {@link Candidate}
 */
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class CandidateDto{
    long candidateId;
    Election election;
    Student student;
}

