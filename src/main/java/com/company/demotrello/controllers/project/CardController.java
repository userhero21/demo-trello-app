package com.company.demotrello.controllers.project;

import com.company.demotrello.controllers.ApiController;
import com.company.demotrello.dtos.project.card.CardChangeColumnDTO;
import com.company.demotrello.dtos.project.card.CardCreateDTO;
import com.company.demotrello.dtos.project.card.CardDTO;
import com.company.demotrello.response.ApiResponse;
import com.company.demotrello.services.project.CardService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CardController extends ApiController<CardService> {

    public CardController(CardService service) {
        super(service);
    }

    @GetMapping(PATH + "/card/{id}")
    public ApiResponse<CardDTO> get(@PathVariable Long id) {
        return new ApiResponse<>(service.get(id));
    }

    @PostMapping(PATH + "/card")
    public ApiResponse<Void> create(@Valid @RequestBody CardCreateDTO dto) {
        service.create(dto);
        return new ApiResponse<>(201);
    }

    @PostMapping(PATH + "/column/changeColumn")
    public ApiResponse<Void> changeColumn(@Valid @RequestBody CardChangeColumnDTO dto) {
        service.changeColumn(dto);
        return new ApiResponse<>(201);
    }

    @DeleteMapping(PATH + "/card/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        // TODO: 19/08/22 standardize status codes
        return new ApiResponse<>(204);
    }


}
