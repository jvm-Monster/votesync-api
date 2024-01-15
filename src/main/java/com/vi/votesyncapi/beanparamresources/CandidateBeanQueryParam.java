package com.vi.votesyncapi.beanparamresources;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CandidateBeanQueryParam {

    @QueryParam("school")
    String school;

    @QueryParam("election-type")
    String electionType;

    @QueryParam("election-name")
    String electionName;

}
