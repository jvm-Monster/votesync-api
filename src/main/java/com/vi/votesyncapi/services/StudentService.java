package com.vi.votesyncapi.services;

import com.vi.votesyncapi.dao.StudentDaoImpl;
import com.vi.votesyncapi.daointerfaces.SchoolDao;
import com.vi.votesyncapi.daointerfaces.StudentDao;
import com.vi.votesyncapi.dto.StudentDto;
import com.vi.votesyncapi.exception.DatabaseConnectionException;
import com.vi.votesyncapi.exception.DuplicateDataException;
import com.vi.votesyncapi.exception.InvalidRequestException;
import com.vi.votesyncapi.exception.ResourceNotFoundException;
import com.vi.votesyncapi.mapper.SchoolMapper;
import com.vi.votesyncapi.mapper.StudentMapper;
import com.vi.votesyncapi.model.Student;
import com.vi.votesyncapi.services_interfaces.Service;
import com.vi.votesyncapi.util.ResourceBeanParam;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

public class StudentService implements Service<Student,String> {

    final StudentDao studentDao;
    final StudentMapper studentMapper;


    public StudentService(StudentDao studentDao, StudentMapper studentMapper){
         this.studentDao = studentDao;
         this.studentMapper = studentMapper;
    }

    @Override
    public Response getEntityService(String entityId, ResourceBeanParam resourceBeanParam) {

        try{
            Student student = studentDao.getStudent(entityId);
            if (student == null) {
                throw new ResourceNotFoundException("Student not found with ID: " + entityId);
            }
            return Response.status(Response.Status.OK).entity(
                    studentDao.getStudent(entityId)
            ).build();
        }catch (ResourceNotFoundException | DatabaseConnectionException e){
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("An error Occurred");
        }
    }

    @Override
    public Response getAllEntitiesService(ResourceBeanParam resourceBeanParam) {
        return null;
    }

    @Override
    public Response addEntityService(Student entity) {
        try{
            studentDao.addStudent(entity);
            return Response.status(Response.Status.CREATED).build();
        }catch (DatabaseConnectionException e){
            throw new DuplicateDataException("Duplicate data : " + entity.getStudentId()+" already exist");
        }
        catch (Exception e){
            throw new DatabaseConnectionException(e.getMessage());
        }
    }

    @Override
    public Response updateEntityService(Student entity) {
        try{
            studentDao.updateStudent(entity);
            return Response.status(Response.Status.NO_CONTENT).entity("Yes it is updated").build();
        }catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST).entity("Error Update").build();
        }
    }

    @Override
    public Response deleteEntityService(String entityId) {
        try{
            studentDao.removeStudent(entityId);
            return Response.status(Response.Status.OK).build();
        }catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
