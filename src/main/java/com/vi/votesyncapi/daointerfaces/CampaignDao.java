package com.vi.votesyncapi.daointerfaces;

import com.vi.votesyncapi.model.Campaign;

import java.util.List;

public interface CampaignDao {
    List<Campaign> getAllCampaigns();
    Campaign getCampaign(String campaignId);
    void addCampaign(Campaign campaign);// add a new campaign
    void removeCampaign(String campaignId);// remove Campaign
    void updateCampaign(Campaign campaign);// update Campaign
}
