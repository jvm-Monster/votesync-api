package com.vi.votesyncapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "school_id"}))
@Entity
public class Candidate {
    @Id
    long candidateId;

    @ManyToOne
    @JoinColumn(name = "school_id")
    School school;

    @ManyToOne
    @JoinColumn(name = "election_id")
    Election election;

    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;

    public Candidate(long candidateId, School school, Election election, Student student) {
        this.candidateId = candidateId;
        this.school = school;
        this.election = election;
        this.student = student;
    }
}
