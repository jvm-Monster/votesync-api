package com.vi.votesyncapi.services;

import com.vi.votesyncapi.dao.ElectionDaoImpl;
import com.vi.votesyncapi.dao.ElectionTypeDaoImpl;
import com.vi.votesyncapi.daointerfaces.ElectionDao;
import com.vi.votesyncapi.daointerfaces.ElectionTypeDao;
import com.vi.votesyncapi.model.Election;
import com.vi.votesyncapi.model.ElectionType;
import jakarta.ws.rs.core.Response;

import java.util.List;

public class ElectionService {
    final ElectionDao electionDao = new ElectionDaoImpl();
    final ElectionTypeDao electionTypeDao = new ElectionTypeDaoImpl();
    public Response getSchoolElections(String schoolId,String electionType){
        try{
           return Response.status(Response.Status.OK).entity(electionTypeDao.getElections(schoolId,electionType)).build();
        }catch (Exception e){
            return  Response.status(Response.Status.BAD_REQUEST).entity("BAD REQUEST: could not get election").build();
        }
    }

    public Response getElectionTypes() {
        try{
            ElectionTypeDaoImpl electionTypeDao = new ElectionTypeDaoImpl();
            List<String> electionTypes = electionTypeDao.getElectionTypes();
            System.out.println(electionTypes);
            return Response.status(Response.Status.OK).entity(electionTypes).build();
        }catch (Exception e){
            return  Response.status(Response.Status.BAD_REQUEST).entity("BAD REQUEST: could not get election").build();
        }
    }
}
