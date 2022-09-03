//package com.company.demotrello.controllers;
//
//import com.company.demotrello.dtos.board.BoardCreateDTO;
//import com.company.demotrello.response.ApiResponse;
//import com.company.demotrello.services.BoardService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//public class BoardController extends ApiController<BoardService> {
//
//    protected BoardController(BoardService service) {
//        super(service);
//    }
//
//
//    @GetMapping(PATH + "/board")
//    public ApiResponse<List<BoardDTO>> getAll() {
//        return new ApiResponse<>(service.getAll());
//    }
//
//
//    @PostMapping(PATH + "/board")
//    public ApiResponse<Void> create(@Valid @RequestBody BoardCreateDTO dto) {
//        service.create(dto);
//        // TODO: 19/08/22 standardize status codes
//        return new ApiResponse<>(201);
//    }
//
//
//
//
//}
