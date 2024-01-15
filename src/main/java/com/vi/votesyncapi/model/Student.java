package com.vi.votesyncapi.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vi.votesyncapi.resource.v1.StudentResourceV1;
import com.vi.votesyncapi.util.StudentLevel;
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
    @Enumerated(EnumType.STRING)
    private StudentLevel studentLevel;

    private String studentEmail;
    private String studentPassword;
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    public Student(String studentId, String studentName, String studentEmail, School school) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.school = school;
    }

    @JsonGetter("studentPassword")
    public String getStudentPassword() {
        return null; // or some logic to handle serialization
    }
}
