package com.vi.votesyncapi.mapper;

import com.vi.votesyncapi.dto.VoteDto;
import com.vi.votesyncapi.model.Vote;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VoteMapper {
    VoteMapper INSTANCE = Mappers.getMapper(VoteMapper.class);

    Vote dtoToModel(VoteDto dto);

    VoteDto modelToDto(Vote model);
}
