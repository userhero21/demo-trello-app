package com.company.demotrello.services.project;

import com.company.demotrello.dtos.project.card.CardCreateDTO;
import com.company.demotrello.dtos.project.card.CardDTO;
import com.company.demotrello.dtos.project.column.ColumnDTO;
import com.company.demotrello.entities.project.Board;
import com.company.demotrello.entities.project.Card;
import com.company.demotrello.entities.project.Column;
import com.company.demotrello.exceptions.GenericNotFoundException;
import com.company.demotrello.mappers.project.CardMapper;
import com.company.demotrello.repository.project.CardRepository;
import com.company.demotrello.repository.project.ColumnRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;
    private final ColumnRepository columnRepository;
    private final CardMapper cardMapper;


    public CardDTO get(@NonNull Long id) {
        Supplier<GenericNotFoundException> notFoundException = () -> new GenericNotFoundException("Card not found", 404);
        Card card = cardRepository.findById(id).orElseThrow(notFoundException);
        return cardMapper.toDTO(card);
    }

    public void create(CardCreateDTO cardCreateDTO) {
        Supplier<GenericNotFoundException> notFoundException = () -> new GenericNotFoundException("Column not found", 404);
        Column column = columnRepository.findById(cardCreateDTO.getColumnId()).orElseThrow(notFoundException);
        Card card = cardMapper.fromCardCreateDTO(cardCreateDTO);
        card.setColumn(column);
        cardRepository.save(card);
    }

    public void delete(@NonNull Long id) {
        cardRepository.deleteById(id);
    }

}
