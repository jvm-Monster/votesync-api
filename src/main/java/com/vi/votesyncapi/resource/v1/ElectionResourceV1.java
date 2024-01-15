package com.vi.votesyncapi.resource.v1;

import com.vi.votesyncapi.services.ElectionService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Produces("application/json")
@Consumes("application/json")
@Path("v1/elections")
public class ElectionResourceV1 {
    final ElectionService electionService = new ElectionService();
    @GET
    public Response getElections(@QueryParam("school-id") String school,@QueryParam("election-type") String electionType){
        return electionService.getSchoolElections(school,electionType);
    }
    @Path("/candidates")
    public CandidateResourceV1 getCandidateResource() {
        return new CandidateResourceV1();
    }
    @GET
    @Path("/election-types")
    public Response getElectionTypes(){
        return electionService.getElectionTypes();
    }

    @Path("/{election-id}/votes")
    public VoteResourceV1 getVoteResource(@PathParam("election-id") long electionId){return new VoteResourceV1();}

}
