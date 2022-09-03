package com.company.demotrello.controllers;

import com.company.demotrello.dtos.project.workspace.WorkspaceCreateDTO;
import com.company.demotrello.response.ApiResponse;
import com.company.demotrello.services.WorkspaceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class WorkspaceController extends ApiController<WorkspaceService> {

    public WorkspaceController(WorkspaceService service) {
        super(service);
    }

    @PostMapping(PATH + "/workspace")
    public ApiResponse<Void> create(@Valid @RequestBody WorkspaceCreateDTO workspaceCreateDTO) {
        service.create(workspaceCreateDTO);
        return new ApiResponse<>(201);

    }


}
