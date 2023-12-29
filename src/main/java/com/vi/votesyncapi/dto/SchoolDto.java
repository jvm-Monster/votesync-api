package com.vi.votesyncapi.dto;

import com.vi.votesyncapi.model.School;

/**
 * DTO for {@link School}
 */

public record SchoolDto(

        String schoolId,
        String schoolName,
        String state
) {
}
