package com.company.demotrello.mappers.project;

import com.company.demotrello.dtos.project.board.BoardCreateDTO;
import com.company.demotrello.dtos.project.board.BoardDTO;
import com.company.demotrello.entities.project.Board;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoardMapper {
    Board fromBoardCreateDTO(BoardCreateDTO dto);

    BoardDTO toDTO(Board entity);

    List<BoardDTO> toDTO(List<Board> entities);
}
