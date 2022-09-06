package com.company.demotrello.mappers.project;

import com.company.demotrello.dtos.project.board.BoardDTO;
import com.company.demotrello.dtos.project.checklist.ChecklistCreateDTO;
import com.company.demotrello.dtos.project.checklist.ChecklistDTO;
import com.company.demotrello.entities.project.Board;
import com.company.demotrello.entities.project.Checklist;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChecklistMapper {
    Checklist fromChecklistCreateDTO(ChecklistCreateDTO dto);

    List<ChecklistDTO> toDTO(List<Checklist> entities);

}
