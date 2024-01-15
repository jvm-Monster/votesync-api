package com.vi.votesyncapi.model;

import com.vi.votesyncapi.util.ElectionStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"electionType", "electionName", "school_id"}))
@Entity
public class Election {
    @Id
    String electionId;
    String electionType;
    String electionName;
    String electionStartDate;
    String electionEndDate;
    @Enumerated(EnumType.STRING)
    ElectionStatus electionStatus;
    @ManyToOne
    @JoinColumn(name = "school_id")
    School school;

    public Election(String electionId, String electionType, String electionName, String electionStartDate, String electionEndDate) {
        this.electionId = electionId;
        this.electionType = electionType;
        this.electionName = electionName;
        this.electionStartDate = electionStartDate;
        this.electionEndDate = electionEndDate;
        /*this.school = school;*/
    }
}
