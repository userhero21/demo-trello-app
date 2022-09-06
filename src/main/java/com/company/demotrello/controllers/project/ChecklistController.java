package com.company.demotrello.controllers.project;

import com.company.demotrello.controllers.ApiController;
import com.company.demotrello.dtos.project.checklist.ChecklistCreateDTO;
import com.company.demotrello.dtos.project.checklist.ChecklistDTO;
import com.company.demotrello.dtos.project.checklist.GetCardChecklistsDTO;
import com.company.demotrello.response.ApiResponse;
import com.company.demotrello.services.project.ChecklistService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ChecklistController extends ApiController<ChecklistService> {

    public ChecklistController(ChecklistService service) {
        super(service);
    }

    @GetMapping(PATH + "/checklist/{cardId}")
    public ApiResponse<List<ChecklistDTO>> get(@PathVariable Long cardId) {
        return new ApiResponse<>(service.get(cardId));
    }

    @PostMapping(PATH + "/checklist")
    public ApiResponse<Void> create(@Valid @RequestBody ChecklistCreateDTO dto) {
        service.create(dto);
        return new ApiResponse<>(201);
    }

    @DeleteMapping(PATH + "/checklist/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        // TODO: 19/08/22 standardize status codes
        return new ApiResponse<>(204);
    }
}
