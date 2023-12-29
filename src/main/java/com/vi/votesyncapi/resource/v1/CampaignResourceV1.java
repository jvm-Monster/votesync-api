package com.vi.votesyncapi.resource.v1;

import com.vi.votesyncapi.dao.CampaignDaoImpl;
import com.vi.votesyncapi.dao.CandidateDaoImpl;
import com.vi.votesyncapi.mapper.CampaignMapper;
import com.vi.votesyncapi.mapper.CandidateMapper;
import com.vi.votesyncapi.model.Campaign;
import com.vi.votesyncapi.model.Candidate;
import com.vi.votesyncapi.services.CampaignService;
import com.vi.votesyncapi.services.CandidateService;
import com.vi.votesyncapi.services_interfaces.Service;
import com.vi.votesyncapi.util.ResourceBeanParam;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("v1/campaigns")
public class CampaignResourceV1 {
    private final Service<Campaign,String> service = new CampaignService(new CampaignDaoImpl(), CampaignMapper.INSTANCE);
    @GET
    public Response getAllCampaignResource(@BeanParam ResourceBeanParam resourceBeanParam){
        return service.getAllEntitiesService(resourceBeanParam);
    }

    @GET
    @Path("/{campaignId}")
    public Response getCampaignResource(@PathParam("campaignId")String campaignId, @BeanParam ResourceBeanParam resourceBeanParam){


        return service.getEntityService(campaignId,resourceBeanParam);
    }

    @POST
    public Response addCampaignResource(Campaign campaign){
        return service.addEntityService(campaign);
    }

    @PUT
    public Response updateCampaignService(Campaign campaign){
        return service.updateEntityService(campaign);
    }

    @DELETE
    @Path("/{campaignId}")
    public Response updateCampaignService(@PathParam("campaignId") String campaignId){
        return service.deleteEntityService(campaignId);
    }
}
