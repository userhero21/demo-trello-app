package com.company.demotrello.services;

import com.company.demotrello.config.security.UserDetails;
import com.company.demotrello.dtos.project.workspace.WorkspaceCreateDTO;
import com.company.demotrello.dtos.project.workspace.WorkspaceDTO;
import com.company.demotrello.entities.project.Workspace;
import com.company.demotrello.exceptions.GenericNotFoundException;
import com.company.demotrello.mappers.project.WorkspaceMapper;
import com.company.demotrello.repository.project.WorkspaceRepository;
import com.company.demotrello.response.project.workspace.WorkspaceResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class WorkspaceService {

    private final WorkspaceRepository workspaceRepository;
    private final WorkspaceMapper workspaceMapper;


    public WorkspaceResponse<List<WorkspaceDTO>, List<WorkspaceDTO>> getAll() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Workspace> myWorkspaces = workspaceRepository.getWorkspacesByOwner(userDetails.authUser());
        List<Workspace> joinWorkspaces = workspaceRepository.getWorkspacesByMembers_Id(userDetails.authUser().getId());

        return new WorkspaceResponse<>(workspaceMapper.toDTO(myWorkspaces), workspaceMapper.toDTO(joinWorkspaces));
    }

    public WorkspaceDTO get(@NonNull Long id) {
        Supplier<GenericNotFoundException> notFoundException = () -> new GenericNotFoundException("Workspace not found", 404);
        Workspace workspace = workspaceRepository.findById(id).orElseThrow(notFoundException);
        return workspaceMapper.toDTO(workspace);
    }

    public void create(WorkspaceCreateDTO workspaceCreateDTO) {
        Workspace workspace = workspaceMapper.fromWorkspaceCreateDTO(workspaceCreateDTO);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        workspace.setOwner(userDetails.authUser());
        workspaceRepository.save(workspace);
    }

    public void delete(@NonNull Long id) {
        workspaceRepository.deleteById(id);
    }
}
