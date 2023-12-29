package com.vi.votesyncapi.mapper;

import com.vi.votesyncapi.dto.StudentDto;
import com.vi.votesyncapi.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);


    Student dtoToModel(StudentDto studentDto);


    StudentDto modelToDto(Student student);
}
