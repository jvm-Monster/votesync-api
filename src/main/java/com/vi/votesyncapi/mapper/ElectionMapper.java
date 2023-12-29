package com.vi.votesyncapi.mapper;

import com.vi.votesyncapi.dto.ElectionDto;
import com.vi.votesyncapi.model.Election;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ElectionMapper {

    ElectionMapper INSTANCE = Mappers.getMapper(ElectionMapper.class);


    Election dtoToModel(ElectionDto dto);


    ElectionDto modelToDto(Election model);
}
