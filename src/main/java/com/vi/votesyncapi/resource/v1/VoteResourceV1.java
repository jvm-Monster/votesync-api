package com.vi.votesyncapi.resource.v1;

import com.vi.votesyncapi.dao.VoteDaoImpl;
import com.vi.votesyncapi.daointerfaces.VoteDao;
import com.vi.votesyncapi.model.Vote;
import com.vi.votesyncapi.services.VoteService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
@Produces("application/json")
@Consumes("application/json")
@Path("v1/votes")
public class VoteResourceV1 {

    final VoteService voteService = new VoteService();
    @GET
    public Response getElectionVotes(@QueryParam("school-id")String schoolId,@QueryParam("election-type")String electionType, @QueryParam("election-name") String electionName){
        return voteService.getEntityService(schoolId,electionType, electionName);
    }
    @GET
    @Path("/student-votes")
    public Response getStudentVotes(
            @QueryParam("student-id")String studentId,
            @QueryParam("school-id")String schoolId,
    @QueryParam("election-type")String electionType, @QueryParam("election-name")String electionName){

        return voteService.getStudentVotes(
                studentId,schoolId,
                electionType,electionName
        );
    }

    @POST
    public Response addVote(Vote vote){
        return voteService.addEntityService(vote);
    }
}
