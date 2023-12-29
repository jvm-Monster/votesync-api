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
    public Response getSchool(@QueryParam("schoolId") String school,@QueryParam("electionType") String electionType){
        return electionService.getSchoolElections(school,electionType);
    }

}
