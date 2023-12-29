package com.vi.votesyncapi.mapper;

import com.vi.votesyncapi.dto.CampaignDto;
import com.vi.votesyncapi.dto.CandidateDto;
import com.vi.votesyncapi.model.Campaign;
import com.vi.votesyncapi.model.Candidate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CampaignMapper {
    CampaignMapper INSTANCE = Mappers.getMapper(CampaignMapper.class);


    Campaign dtoToModel(CampaignDto dto);


    CampaignDto modelToDto(Campaign model);
}
