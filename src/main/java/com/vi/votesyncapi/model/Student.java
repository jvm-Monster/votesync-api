package com.vi.votesyncapi.model;

import com.vi.votesyncapi.resource.v1.StudentResourceV1;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Model for {@link StudentResourceV1}
 */
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Student {
    @Id
    private String studentId;
    private String studentName;
    private String studentEmail;
    private String studentPassword;
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    public Student(String studentId, String studentName, String studentEmail, String studentPassword, School school) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentPassword = studentPassword;
        this.school = school;
    }
}
