package com.company.demotrello.mappers.project;

import com.company.demotrello.dtos.project.workspace.WorkspaceCreateDTO;
import com.company.demotrello.entities.project.Workspace;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkspaceMapper {
    Workspace fromWorkspaceCreateDTO(WorkspaceCreateDTO dto);
}
