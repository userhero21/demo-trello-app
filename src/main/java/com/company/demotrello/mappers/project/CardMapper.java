package com.company.demotrello.mappers.project;

import com.company.demotrello.dtos.project.card.CardCreateDTO;
import com.company.demotrello.dtos.project.card.CardDTO;
import com.company.demotrello.entities.project.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper {
    Card fromCardCreateDTO(CardCreateDTO dto);

    CardDTO toDTO(Card entity);


}
