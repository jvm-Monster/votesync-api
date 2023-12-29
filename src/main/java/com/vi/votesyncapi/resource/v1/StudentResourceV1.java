package com.vi.votesyncapi.resource.v1;

import com.vi.votesyncapi.dao.StudentDaoImpl;
import com.vi.votesyncapi.mapper.StudentMapper;
import com.vi.votesyncapi.model.Student;
import com.vi.votesyncapi.services.StudentService;
import com.vi.votesyncapi.services_interfaces.Service;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

/**
 * API RESOURCE for {@link Student}
 */
@Produces("application/json")
@Consumes("application/json")
@Path("v1/students")
public class StudentResourceV1 {

    Service<Student,String> service = new StudentService(new StudentDaoImpl(), StudentMapper.INSTANCE);

    @GET
    @Path("/{studentId}")
    public Response retrieveStudent(@PathParam("studentId") String studentId) {
        return service.getEntityService(studentId,null);
    }
    @POST
    public Response registerStudent(Student student) {return service.addEntityService(student);}

    @PUT
    public Response updateStudent(Student student){
        return service.updateEntityService(student);
    }

    @DELETE
    @Path("/{studentId}")
    public Response deleteStudent(@PathParam("studentId") String studentId) {
        return service.deleteEntityService(studentId);
    }
}
