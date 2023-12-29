package com.vi.votesyncapi.services;

import com.vi.votesyncapi.dao.CandidateDaoImpl;
import com.vi.votesyncapi.daointerfaces.CandidateDao;
import com.vi.votesyncapi.dto.CandidateDto;
import com.vi.votesyncapi.mapper.CandidateMapper;
import com.vi.votesyncapi.model.Candidate;
import com.vi.votesyncapi.services_interfaces.Service;
import com.vi.votesyncapi.util.ResourceBeanParam;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.vi.votesyncapi.helperclass.CheckDataSummary.checkDataSummary;

public class CandidateService implements Service<Candidate,Integer> {
    private final CandidateDao candidateDao;
    private final CandidateMapper candidateMapper;

    public CandidateService(CandidateDao candidateDao, CandidateMapper candidateMapper) {
        this.candidateDao = candidateDao;
        this.candidateMapper = candidateMapper;
    }

    @Override
    public Response getEntityService(Integer entityId, ResourceBeanParam resourceBeanParam) {
        try{
            Candidate candidate = candidateDao.getCandidate(entityId);
           /* if(checkDataSummary(resourceBeanParam)){
                return Response.status(Response.Status.OK)
                        .entity(candidate)
                        .build();
            }
*/
            CandidateDto candidateDto = candidateMapper.modelToDto(candidate);
            return Response.status(Response.Status.OK)
                    .entity(candidateDto)
                    .build();

        }catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Could not request service for specified candidate")
                    .build();
        }
    }

    @Override
    public Response getAllEntitiesService(ResourceBeanParam resourceBeanParam) {
        try{

            List<Candidate> candidateList = candidateDao.getCandidates();

            List<CandidateDto> responseEntity = candidateList.stream()
                    .map(candidateMapper::modelToDto)
                    .collect(Collectors.toList());
            return Response.status(Response.Status.OK)
                    .entity(responseEntity)
                    .build();
        }catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Could not request service for all candidates")
                    .build();
        }
    }

    @Override
    public Response addEntityService(Candidate entity) {
        try{
            candidateDao.addCandidate(entity);
            return Response.status(Response.Status.OK)
                    .build();
        }catch (Exception e){

            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Could not request service for all candidates")
                    .build();
        }

    }

    @Override
    public Response updateEntityService(Candidate entity) {
        try{
            candidateDao.updateCandidate(entity);
            return Response.status(Response.Status.OK)
                    .build();
        }catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Could not request service to update candidate")
                    .build();
        }
    }

    @Override
    public Response deleteEntityService(Integer entityId) {
        try{
            candidateDao.removeCandidate(entityId);
            return Response.status(Response.Status.OK)
                    .build();
        }catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Could not request service to delete candidate")
                    .build();
        }
    }

}
