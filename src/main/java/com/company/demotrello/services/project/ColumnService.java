package com.company.demotrello.services.project;

import com.company.demotrello.dtos.project.column.ColumnCreateDTO;
import com.company.demotrello.dtos.project.column.ColumnDTO;
import com.company.demotrello.entities.project.Board;
import com.company.demotrello.entities.project.Column;
import com.company.demotrello.exceptions.GenericNotFoundException;
import com.company.demotrello.mappers.project.ColumnMapper;
import com.company.demotrello.repository.project.BoardRepository;
import com.company.demotrello.repository.project.ColumnRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class ColumnService {

    private final BoardRepository boardRepository;
    private final ColumnRepository columnRepository;
    private final ColumnMapper columnMapper;


    public List<ColumnDTO> get(@NonNull Long id) {
        Supplier<GenericNotFoundException> notFoundException = () -> new GenericNotFoundException("Board not found", 404);
        Board board = boardRepository.findById(id).orElseThrow(notFoundException);
        return columnMapper.toDTO((List<Column>) board.getColumns());
    }

    public void create(ColumnCreateDTO columnCreateDTO) {
        Supplier<GenericNotFoundException> notFoundException = () -> new GenericNotFoundException("Board not found", 404);
        Board board = boardRepository.findById(columnCreateDTO.getBoardId()).orElseThrow(notFoundException);
        Column column = columnMapper.fromColumnCreateDTO(columnCreateDTO);
        column.setBoard(board);
        // TODO: 9/5/2022 fic column position
        columnRepository.save(column);
    }

    public void delete(@NonNull Long id) {
        columnRepository.deleteById(id);
    }

}
