package com.vi.votesyncapi.services;

import com.vi.votesyncapi.beanparamresources.ResourceBeanParam;
import com.vi.votesyncapi.dao.VoteDaoImpl;
import com.vi.votesyncapi.daointerfaces.VoteDao;
import com.vi.votesyncapi.dto.CandidateDto;
import com.vi.votesyncapi.dto.VoteDto;
import com.vi.votesyncapi.exception.DatabaseConnectionException;
import com.vi.votesyncapi.exception.DuplicateDataException;
import com.vi.votesyncapi.exception.ResourceNotFoundException;
import com.vi.votesyncapi.mapper.VoteMapper;
import com.vi.votesyncapi.model.*;
import com.vi.votesyncapi.services_interfaces.Service;
import com.vi.votesyncapi.util.DatabaseManager;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

public class VoteService {
    VoteDao voteDao = new VoteDaoImpl(new DatabaseManager());
    VoteMapper voteMapper = VoteMapper.INSTANCE;

    public Response getStudentVotes(String studentId, String schoolId,String electionType,String electionName){

         Vote vote = voteDao.getStudentVotes(studentId,schoolId,electionType,electionName);
        if(vote==null){
            throw new  ResourceNotFoundException("Resource not found");
        }
        VoteDto voteDto = new VoteDto();
        voteDto.setVoteId(vote.getVoteId());
        voteDto.setVoted(vote.isVoted());
        voteDto.setElection(new Election());
        voteDto.getElection().setElectionType(vote.getElection().getElectionType());
        voteDto.getElection().setElectionName(vote.getElection().getElectionName());
        voteDto.getElection().setElectionId(vote.getElection().getElectionId());
        voteDto.setSchool(new School());
        voteDto.getSchool().setSchoolId(vote.getSchool().getSchoolId());
        voteDto.setStudent(new Student());
        voteDto.getStudent().setStudentId(vote.getStudent().getStudentId());
        voteDto.setCandidate(new Candidate());
        voteDto.getCandidate().setCandidateId(vote.getCandidate().getCandidateId());
        try{
            return Response.status(Response.Status.OK)
                    .entity(voteDto)
                    .build();
        }catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e).build();
        }
    }

   public Response getEntityService(String schoolId,String electionType,String electionName){

         try{
            return Response.status(Response.Status.OK)
                    .entity(voteDao.getVotesForElection(schoolId, electionType,electionName))
                    .build();
        }catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e).build();
        }
    }

    public Response addEntityService(Vote entity) {
        try{
            voteDao.createVote(entity);
            return Response.status(Response.Status.CREATED).build();
        }catch (DatabaseConnectionException e){
            throw new DuplicateDataException("Duplicate data : " + entity+" already exist");
        }
        catch (Exception e){
            throw new DatabaseConnectionException(e.getMessage());
        }

    }
}
