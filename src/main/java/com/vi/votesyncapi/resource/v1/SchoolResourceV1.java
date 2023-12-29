package com.vi.votesyncapi.resource.v1;

import com.vi.votesyncapi.dao.SchoolDaoImpl;
import com.vi.votesyncapi.mapper.SchoolMapper;
import com.vi.votesyncapi.model.School;
import com.vi.votesyncapi.services.SchoolService;
import com.vi.votesyncapi.services_interfaces.Service;
import com.vi.votesyncapi.util.ResourceBeanParam;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

/**
 * API RESOURCE for {@link School}
 */
@Produces("application/json")
@Consumes("application/json")
@Path("v1/schools")
public class SchoolResourceV1 {
    Service<School,String> service= new SchoolService(new SchoolDaoImpl(), SchoolMapper.INSTANCE);

    @GET
    public Response getAllSchool(){
        return  service.getAllEntitiesService(null);
    }
    @GET
    @Path("/{schoolId}")
    public Response getSchool(@PathParam("schoolId")String schoolId, @BeanParam ResourceBeanParam resourceBeanParam){
        return service.getEntityService(schoolId,resourceBeanParam);
    }

    @POST
    public Response addSchool(School school){
        return service.addEntityService(school);
    }

    @PUT
    public Response updateSchool(School school){
        return service.updateEntityService(school);
    }

    @DELETE
    @Path("/{schoolId}")
    public Response updateSchool(@PathParam("schoolId") String schoolId){
        return service.deleteEntityService(schoolId);
    }

}
