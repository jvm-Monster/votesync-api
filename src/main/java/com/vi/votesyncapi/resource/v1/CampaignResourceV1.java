package com.vi.votesyncapi.resource.v1;

import com.vi.votesyncapi.dao.CampaignDaoImpl;
import com.vi.votesyncapi.mapper.CampaignMapper;
import com.vi.votesyncapi.model.Campaign;
import com.vi.votesyncapi.services.CampaignService;
import com.vi.votesyncapi.services_interfaces.Service;
import com.vi.votesyncapi.beanparamresources.ResourceBeanParam;
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
    @Path("/{campaign-id}")
    public Response getCampaignResource(@PathParam("campaign-id")String campaignId, @BeanParam ResourceBeanParam resourceBeanParam){


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
    @Path("/{campaign-id}")
    public Response updateCampaignService(@PathParam("campaign-id") String campaignId){
        return service.deleteEntityService(campaignId);
    }
}
