package com.vi.votesyncapi.dto;

import com.vi.votesyncapi.model.Candidate;
import com.vi.votesyncapi.model.Election;
import com.vi.votesyncapi.model.School;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * DTO for {@link Candidate}
 */

public record CandidateDto(
        String candidateId,
        Election election,
        School school
) {
}
