package com.company.demotrello.controllers.project;

import com.company.demotrello.controllers.ApiController;
import com.company.demotrello.dtos.project.column.ColumnChangePositionDTO;
import com.company.demotrello.dtos.project.column.ColumnCreateDTO;
import com.company.demotrello.dtos.project.column.ColumnDTO;
import com.company.demotrello.response.ApiResponse;
import com.company.demotrello.services.project.ColumnService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ColumnController extends ApiController<ColumnService> {

    public ColumnController(ColumnService service) {
        super(service);
    }

    @GetMapping(PATH + "/column/{id}")
    public ApiResponse<List<ColumnDTO>> get(@PathVariable Long id) {
        return new ApiResponse<>(service.get(id));
    }

    @PostMapping(PATH + "/column")
    public ApiResponse<Void> create(@Valid @RequestBody ColumnCreateDTO dto) {
        service.create(dto);
        return new ApiResponse<>(201);
    }

    @PostMapping(PATH + "/column/changePosition")
    public ApiResponse<Void> changePosition(@Valid @RequestBody ColumnChangePositionDTO dto) {
        service.changePosition(dto);
        return new ApiResponse<>(201);
    }

    @DeleteMapping(PATH + "/column/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        // TODO: 19/08/22 standardize status codes
        return new ApiResponse<>(204);
    }


}
