package com.vi.votesyncapi.services;

import com.vi.votesyncapi.daointerfaces.CampaignDao;
import com.vi.votesyncapi.dto.CampaignDto;
import com.vi.votesyncapi.exception.ResourceNotFoundException;
import com.vi.votesyncapi.mapper.CampaignMapper;
import com.vi.votesyncapi.model.Campaign;
import com.vi.votesyncapi.services_interfaces.Service;
import com.vi.votesyncapi.beanparamresources.ResourceBeanParam;
import jakarta.ws.rs.core.Response;

import java.util.List;

public class CampaignService implements Service<Campaign,String> {
    final CampaignDao campaignDao;
    final CampaignMapper campaignMapper;
    public CampaignService(CampaignDao campaignDao,CampaignMapper campaignMapper) {
         this.campaignDao = campaignDao;
         this.campaignMapper=campaignMapper;
    }

    @Override
    public Response getEntityService(String entityId, ResourceBeanParam resourceBeanParam) {
        try{
            Campaign campaign = campaignDao.getCampaign(entityId);
            if(campaign==null){
                throw new ResourceNotFoundException("Resource not found for id: "+entityId);
            }
            CampaignDto campaignDto = campaignMapper.modelToDto(campaign);
            campaignDto.setCandidateId(String.valueOf(campaign.getCandidate().getCandidateId()));
            return Response.status(Response.Status.OK)
                    .entity(campaignDto)
                    .build();
        } catch (ResourceNotFoundException r){
            throw r;
        }
        catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("An error")
                    .build();
        }
    }

    @Override
    public Response getAllEntitiesService(ResourceBeanParam resourceBeanParam) {
        try{
            List<Campaign> campaignList = campaignDao.getAllCampaigns();

            List<?> responseEntity = campaignList.stream().map(
                    campaign -> {
                        CampaignDto campaignDto = campaignMapper.modelToDto(campaign);
                        campaignDto.setCandidateId(String.valueOf(campaign.getCandidate().getCandidateId()));
                        return campaignDto;
            }
            ).toList();
            return Response.status(Response.Status.OK)
                    .entity(responseEntity)
                    .build();
        }catch (Exception e){
            return Response.status(Response.Status.NOT_FOUND)
                    .build();
        }
    }

    @Override
    public Response addEntityService(Campaign entity) {
        try{
            campaignDao.addCampaign(entity);
            return Response.status(Response.Status.OK)
                    .build();
        }catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Could not request service to get specified campaigns")
                    .build();
        }
    }

    @Override
    public Response updateEntityService(Campaign entity) {
        try{
            campaignDao.updateCampaign(entity);
            return Response.status(Response.Status.OK)
                    .build();
        }catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Could not request service to get specified campaigns")
                    .build();
        }
    }

    @Override
    public Response deleteEntityService(String entityId) {
        try{
            campaignDao.removeCampaign(entityId);
            return Response.status(Response.Status.OK)
                    .build();
        }catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Could not request service to get specified campaigns")
                    .build();
        }
    }
}
