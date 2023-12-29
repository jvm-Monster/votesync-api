package com.vi.votesyncapi.dto;


import com.vi.votesyncapi.model.Election;
import com.vi.votesyncapi.model.School;

/**
 * DTO for {@link Election}
 */
public record ElectionDto(
        int electionId,
        String electionType,
        String electionName,
        String electionStartDate,
        String electionEndDate,
        School school
) {
}
