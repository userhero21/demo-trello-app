package com.company.demotrello.services.project;

import com.company.demotrello.dtos.project.checklist.ChecklistCreateDTO;
import com.company.demotrello.dtos.project.checklist.ChecklistDTO;
import com.company.demotrello.dtos.project.checklist.GetCardChecklistsDTO;
import com.company.demotrello.entities.project.Card;
import com.company.demotrello.entities.project.Checklist;
import com.company.demotrello.exceptions.GenericNotFoundException;
import com.company.demotrello.mappers.project.ChecklistMapper;
import com.company.demotrello.repository.project.CardRepository;
import com.company.demotrello.repository.project.ChecklistRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class ChecklistService {

    private final ChecklistMapper checklistMapper;
    private final ChecklistRepository checklistRepository;
    private final CardRepository cardRepository;


    public void create(ChecklistCreateDTO checklistCreateDTO) {
        Supplier<GenericNotFoundException> notFoundException = () -> new GenericNotFoundException("Card not found", 404);
        Card card = cardRepository.findById(checklistCreateDTO.getCardId()).orElseThrow(notFoundException);
        Checklist checklist = checklistMapper.fromChecklistCreateDTO(checklistCreateDTO);
        checklist.setCard(card);
        checklistRepository.save(checklist);
    }

    public List<ChecklistDTO> get(Long id) {
        Supplier<GenericNotFoundException> notFoundException = () -> new GenericNotFoundException("Card not found", 404);
        if (!cardRepository.existsById(id)) throw notFoundException.get();
        List<Checklist> checklists = checklistRepository.getChecklistsByCardId(id);
        return checklistMapper.toDTO(checklists);
    }

    public void delete(@NonNull Long id) {
        cardRepository.deleteById(id);
    }
}
