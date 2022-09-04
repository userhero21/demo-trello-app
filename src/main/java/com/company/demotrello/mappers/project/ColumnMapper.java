package com.company.demotrello.mappers.project;

import com.company.demotrello.dtos.project.column.ColumnCreateDTO;
import com.company.demotrello.dtos.project.column.ColumnDTO;
import com.company.demotrello.entities.project.Column;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ColumnMapper {
    Column fromColumnCreateDTO(ColumnCreateDTO dto);

    List<ColumnDTO> toDTO(List<Column> entities);

}
