package com.vi.votesyncapi;

import com.vi.votesyncapi.dao.SchoolDaoImpl;
import com.vi.votesyncapi.daointerfaces.SchoolDao;
import com.vi.votesyncapi.model.School;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/hi")
public class VoteSyncResource {
    @GET

    public String hello( ) {
        return "Ok";
    }
}