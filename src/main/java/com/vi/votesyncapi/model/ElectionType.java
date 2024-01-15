package com.vi.votesyncapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"electionType", "school_id"}))
@Entity
public class ElectionType {
    @Id
    private String electionType;

    @OneToMany(mappedBy = "electionType", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Election> elections;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;


    public ElectionType(String electionType, List<Election> elections) {
        this.electionType = electionType;
        this.elections = elections;
    }
}
