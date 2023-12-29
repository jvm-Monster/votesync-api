package com.vi.votesyncapi.mapper;

import com.vi.votesyncapi.dto.SchoolDto;
import com.vi.votesyncapi.model.School;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SchoolMapper {
    SchoolMapper INSTANCE = Mappers.getMapper(SchoolMapper.class);


    School dtoToModel(SchoolDto dto);


    SchoolDto modelToDto(School model);
}
