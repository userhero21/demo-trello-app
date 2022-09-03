package com.company.demotrello.services;

import com.company.demotrello.config.security.UserDetails;
import com.company.demotrello.dtos.project.workspace.WorkspaceCreateDTO;
import com.company.demotrello.entities.auth.AuthUser;
import com.company.demotrello.entities.project.Workspace;
import com.company.demotrello.mappers.project.WorkspaceMapper;
import com.company.demotrello.repository.WorkspaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkspaceService {

    private final WorkspaceRepository workspaceRepository;
    private final WorkspaceMapper workspaceMapper;


    public void create(WorkspaceCreateDTO workspaceCreateDTO) {
        Workspace workspace = workspaceMapper.fromWorkspaceCreateDTO(workspaceCreateDTO);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        workspace.setOwner(userDetails.authUser());
        workspaceRepository.save(workspace);
    }
}
