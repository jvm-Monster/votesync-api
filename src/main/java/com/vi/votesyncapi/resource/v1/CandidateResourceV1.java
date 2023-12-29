package com.vi.votesyncapi.resource.v1;

import com.vi.votesyncapi.dao.CandidateDaoImpl;
import com.vi.votesyncapi.mapper.CandidateMapper;
import com.vi.votesyncapi.model.Campaign;
import com.vi.votesyncapi.model.Candidate;
import com.vi.votesyncapi.services.CandidateService;
import com.vi.votesyncapi.services_interfaces.Service;
import com.vi.votesyncapi.util.ResourceBeanParam;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("v1/candidates")
public class CandidateResourceV1 {
    private final Service<Candidate,Integer> service=new CandidateService(new CandidateDaoImpl(), CandidateMapper.INSTANCE);

    @GET
    public Response getCandidates(@BeanParam ResourceBeanParam resourceBeanParam){
        return service.getAllEntitiesService(resourceBeanParam);
    }

    @GET
    @Path("/{candidateId}")
    public Response getCandidate(@PathParam("candidateId")int candidateId, @BeanParam ResourceBeanParam resourceBeanParam){
        return service.getEntityService(candidateId,resourceBeanParam);
    }

    @POST
    public Response createCandidate(Candidate candidate){
        return service.addEntityService(candidate);
    }

    @PUT
    public Response updateCandidate(Candidate candidate){
        return service.updateEntityService(candidate);
    }

    @DELETE
    @Path("/{candidateId}")
    public Response deleteCandidate(@PathParam("candidateId") int candidateId){
        return service.deleteEntityService(candidateId);
    }
}
