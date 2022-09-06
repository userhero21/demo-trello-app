package com.company.demotrello.controllers.project;

import com.company.demotrello.controllers.ApiController;
import com.company.demotrello.dtos.project.workspace.WorkspaceAddMemberDTO;
import com.company.demotrello.dtos.project.workspace.WorkspaceCreateDTO;
import com.company.demotrello.dtos.project.workspace.WorkspaceDTO;
import com.company.demotrello.dtos.project.workspace.WorkspaceUpdateDTO;
import com.company.demotrello.response.ApiResponse;
import com.company.demotrello.response.project.workspace.WorkspaceResponse;
import com.company.demotrello.services.project.WorkspaceService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class WorkspaceController extends ApiController<WorkspaceService> {

    protected WorkspaceController(WorkspaceService service) {
        super(service);
    }

    @GetMapping(PATH + "/workspace")
    public ApiResponse<WorkspaceResponse<List<WorkspaceDTO>, List<WorkspaceDTO>>> getAll() {
        return new ApiResponse<>(service.getAll());
    }

    @GetMapping(PATH + "/workspace/{id}")
    public ApiResponse<WorkspaceDTO> get(@PathVariable Long id) {
        return new ApiResponse<>(service.get(id));
    }

    @PostMapping(PATH + "/workspace")
    public ApiResponse<Void> create(@Valid @RequestBody WorkspaceCreateDTO dto) {
        service.create(dto);
        return new ApiResponse<>(201);
    }

    @PostMapping(PATH + "/workspace/update")
    public ApiResponse<Void> update(@Valid @RequestBody WorkspaceUpdateDTO dto) {
        service.update(dto);
        return new ApiResponse<>(201);
    }

    @PostMapping(PATH + "/workspace/add/member")
    public ApiResponse<Void> addMember(@Valid @RequestBody WorkspaceAddMemberDTO dto) {
        service.addMember(dto);
        return new ApiResponse<>(201);
    }

    @DeleteMapping(PATH + "/workspace/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        // TODO: 19/08/22 standardize status codes
        return new ApiResponse<>(204);
    }


}
