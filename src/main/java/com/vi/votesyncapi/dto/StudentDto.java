package com.vi.votesyncapi.dto;

import com.vi.votesyncapi.model.Student;

/**
 * DTO for {@link Student}
 */

public record StudentDto(
        String studentId,
        String studentName,
        String studentEmail,
        SchoolDto schoolDto
) {
}
