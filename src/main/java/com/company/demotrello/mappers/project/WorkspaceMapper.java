package com.company.demotrello.mappers.project;

import com.company.demotrello.dtos.project.workspace.WorkspaceCreateDTO;
import com.company.demotrello.dtos.project.workspace.WorkspaceDTO;
import com.company.demotrello.entities.project.Workspace;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WorkspaceMapper {
    Workspace fromWorkspaceCreateDTO(WorkspaceCreateDTO dto);

    WorkspaceDTO toDTO(Workspace entity);

    List<WorkspaceDTO> toDTO(List<Workspace> entities);

}
