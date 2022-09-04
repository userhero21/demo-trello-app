package com.company.demotrello.controllers.project;

import com.company.demotrello.controllers.ApiController;
import com.company.demotrello.dtos.project.board.BoardCreateDTO;
import com.company.demotrello.dtos.project.board.BoardDTO;
import com.company.demotrello.response.ApiResponse;
import com.company.demotrello.response.project.board.BoardResponse;
import com.company.demotrello.services.BoardService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BoardController extends ApiController<BoardService> {

    protected BoardController(BoardService service) {
        super(service);
    }

    @GetMapping(PATH + "/board")
    public ApiResponse<BoardResponse<List<BoardDTO>, List<BoardDTO>>> getAll() {
        return new ApiResponse<>(service.getAll());
    }

    @GetMapping(PATH + "/board/{id}")
    public ApiResponse<BoardDTO> get(@PathVariable Long id) {
        return new ApiResponse<>(service.get(id));
    }

    @PostMapping(PATH + "/board")
    public ApiResponse<Void> create(@Valid @RequestBody BoardCreateDTO dto) {
        service.create(dto);
        // TODO: 19/08/22 standardize status codes
        return new ApiResponse<>(201);
    }

    @DeleteMapping(PATH + "/board/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        // TODO: 19/08/22 standardize status codes
        return new ApiResponse<>(204);
    }


}
