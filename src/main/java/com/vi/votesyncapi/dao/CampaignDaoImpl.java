package com.vi.votesyncapi.dao;

import com.vi.votesyncapi.daointerfaces.CampaignDao;
import com.vi.votesyncapi.dto.CampaignDto;
import com.vi.votesyncapi.mapper.CampaignMapper;
import com.vi.votesyncapi.model.Campaign;
import com.vi.votesyncapi.model.Candidate;
import com.vi.votesyncapi.util.DatabaseManager;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class CampaignDaoImpl implements CampaignDao {
    DatabaseManager databaseManager = new DatabaseManager();


    @Override
    public List<Campaign> getAllCampaigns() {
        return databaseManager.executeInTransaction(()->{
            TypedQuery<Campaign> typedQuery = databaseManager.entityManager.createQuery(
                    "SELECT c FROM Campaign c", Campaign.class
            );

            List<Campaign> campaigns = typedQuery.getResultList();
            campaigns.forEach(campaign -> {
                if (campaign.getCampaignPromise() != null) {
                    campaign.getCampaignMajorGoals().size();
                }
            });

            return typedQuery.getResultList();
        },"");
    }

    @Override
    public Campaign getCampaign(String campaignId) {
        return databaseManager.executeInTransaction(()->{
            Campaign campaign = databaseManager.entityManager.find(Campaign.class,campaignId);
            campaign.getCampaignMajorGoals().forEach(camp -> {
                if (camp!= null) {
                    campaign.getCampaignMajorGoals().size();
                }
            });
            return  campaign;
        },"");
    }

    @Override
    public void addCampaign(Campaign campaign) {
        String campaignId = "camp_"+ campaign.getCandidate().getCandidateId();
        campaign.setCampaignId(campaignId);
        databaseManager.executeInTransaction(()->{
            databaseManager.entityManager.persist(campaign);
        },"");
    }

    @Override
    public void removeCampaign(String campaignId) {
        databaseManager.executeInTransaction(()->{
            Campaign campaignEntity = databaseManager.entityManager.find(Campaign.class,campaignId);
            databaseManager.entityManager.remove(campaignEntity);
        },"");
    }

    @Override
    public void updateCampaign(Campaign campaign) {
        databaseManager.executeInTransaction(()->{
            Campaign campaignEntity = databaseManager.entityManager.find(Campaign.class,campaign.getCampaignId());
            if(campaignEntity!=null){
                 campaignEntity.setCampaignPromise(campaign.getCampaignPromise());
                 campaignEntity.setCampaignTitle(campaign.getCampaignTitle());
                 campaignEntity.setCampaignMajorGoals(campaign.getCampaignMajorGoals());
            }
        },"");
    }
}
