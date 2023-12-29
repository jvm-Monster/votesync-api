package com.vi.votesyncapi.services;

import com.vi.votesyncapi.dao.SchoolDaoImpl;
import com.vi.votesyncapi.dao.StudentDaoImpl;
import com.vi.votesyncapi.daointerfaces.SchoolDao;
import com.vi.votesyncapi.daointerfaces.StudentDao;
import com.vi.votesyncapi.dto.SchoolDto;
import com.vi.votesyncapi.mapper.SchoolMapper;
import com.vi.votesyncapi.model.School;
import com.vi.votesyncapi.model.Student;
import com.vi.votesyncapi.services_interfaces.Service;
import com.vi.votesyncapi.util.ResourceBeanParam;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.util.List;

import static com.vi.votesyncapi.helperclass.CheckDataSummary.checkDataSummary;

public class SchoolService implements Service<School,String> {
    final SchoolDao schoolDao;
    final SchoolMapper schoolMapper;

    public SchoolService(SchoolDao schoolDao, SchoolMapper schoolMapper){
        this.schoolDao=schoolDao;
        this.schoolMapper=schoolMapper;
    }

    @Override
    public Response getEntityService(String entityId, ResourceBeanParam resourceBeanParam) {
        try{
            School school = schoolDao.retrieveSchool(entityId);
            if(checkDataSummary(resourceBeanParam))
             return Response.status(Response.Status.FOUND)
                    .entity(school)
                    .build();
            SchoolDto schoolDto = schoolMapper.modelToDto(school);
            return Response.status(Response.Status.FOUND)
                    .entity(schoolDto)
                    .build();

        }catch (Exception e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Override
    public Response getAllEntitiesService(ResourceBeanParam resourceBeanParam) {
        List<School> schoolList = schoolDao.retrieveAllSchool();
        try{
            return Response.status(Response.Status.OK)
                    .entity(schoolList)
                    .build();
        }catch (Exception e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Override
    public Response addEntityService(School entity) {
        try{
            schoolDao.addSchool(entity);
            return Response.status(Response.Status.CREATED).build();
        }catch (Exception e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Override
    public Response updateEntityService(School entity) {
        try{
            schoolDao.updateSchool(entity);
            return Response.status(Response.Status.CREATED).build();
        }catch (Exception e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Override
    public Response deleteEntityService(String entityId) {
        try{
            schoolDao.removeSchool(entityId);
            return Response.status(Response.Status.NO_CONTENT).build();
        }catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}