package com.company.demotrello.services.project;

import com.company.demotrello.config.Temp;
import com.company.demotrello.dtos.project.workspace.WorkspaceCreateDTO;
import com.company.demotrello.dtos.project.workspace.WorkspaceDTO;
import com.company.demotrello.entities.project.Workspace;
import com.company.demotrello.exceptions.GenericNotFoundException;
import com.company.demotrello.mappers.project.WorkspaceMapper;
import com.company.demotrello.repository.project.WorkspaceRepository;
import com.company.demotrello.response.project.workspace.WorkspaceResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class WorkspaceService {

    private final WorkspaceRepository workspaceRepository;
    private final WorkspaceMapper workspaceMapper;


    public WorkspaceResponse<List<WorkspaceDTO>, List<WorkspaceDTO>> getAll() {
        List<Workspace> myWorkspaces = workspaceRepository.getWorkspacesByOwner(Temp.authUser);
        List<Workspace> joinWorkspaces = workspaceRepository.getWorkspacesByMembers_Id(Temp.authUser.getId());

        return new WorkspaceResponse<>(workspaceMapper.toDTO(myWorkspaces), workspaceMapper.toDTO(joinWorkspaces));
    }

    public WorkspaceDTO get(@NonNull Long id) {
        Supplier<GenericNotFoundException> notFoundException = () -> new GenericNotFoundException("Workspace not found", 404);
        Workspace workspace = workspaceRepository.findById(id).orElseThrow(notFoundException);
        return workspaceMapper.toDTO(workspace);
    }

    public void create(WorkspaceCreateDTO workspaceCreateDTO) {
        Workspace workspace = workspaceMapper.fromWorkspaceCreateDTO(workspaceCreateDTO);
        workspace.setOwner(Temp.authUser);
        workspaceRepository.save(workspace);
    }

    public void delete(@NonNull Long id) {
        workspaceRepository.deleteById(id);
    }
}
