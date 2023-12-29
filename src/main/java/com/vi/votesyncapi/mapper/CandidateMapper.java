package com.vi.votesyncapi.mapper;

import com.vi.votesyncapi.dto.CandidateDto;
import com.vi.votesyncapi.model.Candidate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CandidateMapper {
    CandidateMapper INSTANCE = Mappers.getMapper(CandidateMapper.class);


    Candidate dtoToModel(CandidateDto dto);


    CandidateDto modelToDto(Candidate model);
}
