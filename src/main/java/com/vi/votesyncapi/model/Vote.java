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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "school_id", "election_id"}))
@Entity
public class Vote {
    @Id
    private String voteId;
    private boolean voted;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "election_id")
    private Election election;

    public Vote(String voteId, boolean voted, Student student, School school, Candidate candidate, Election election) {
        this.voteId = voteId;
        this.voted = voted;
        this.student = student;
        this.school = school;
        this.candidate = candidate;
        this.election = election;
    }
}
