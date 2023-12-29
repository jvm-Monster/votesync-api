package com.vi.votesyncapi.dto;

import com.vi.votesyncapi.model.Campaign;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * DTO for {@link Campaign}
 */

@Setter
@Getter
@RequiredArgsConstructor
public class CampaignDto{
        String campaignId;
        String campaignTitle;
        String campaignPromise;
        List<String> campaignMajorGoals;
        String candidateId;

    public CampaignDto(String campaignId, String campaignTitle, String campaignPromise, List<String> campaignMajorGoals, String candidateId) {
        this.campaignId = campaignId;
        this.campaignTitle = campaignTitle;
        this.campaignPromise = campaignPromise;
        this.campaignMajorGoals = campaignMajorGoals;
        this.candidateId = candidateId;
    }


}


/*public record CampaignDto(
        String campaignId,
        String campaignTitle,
        String campaignPromise,
        List<String> campaignMajorGoals,
        String candidateId

) {

}*/

