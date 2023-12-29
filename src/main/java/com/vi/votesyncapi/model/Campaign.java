package com.vi.votesyncapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Campaign {
    @Id
    String campaignId;
    String campaignTitle;
    String campaignPromise;

    @ElementCollection
    @CollectionTable(name = "campaign_goals", joinColumns = @JoinColumn(name = "campaign_id"))
    List<String> campaignMajorGoals;

    @ManyToOne
    @JoinColumn(name = "candidate_candidate_id")
    Candidate candidate;

    public Campaign(String campaignId, String campaignTitle, String campaignPromise, List<String> campaignMajorGoals, Candidate candidate) {
        this.campaignId = campaignId;
        this.campaignTitle = campaignTitle;
        this.campaignPromise = campaignPromise;
        this.campaignMajorGoals = campaignMajorGoals;
        this.candidate = candidate;
    }
}
