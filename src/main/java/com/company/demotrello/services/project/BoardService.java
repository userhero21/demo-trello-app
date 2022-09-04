package com.company.demotrello.services.project;

import com.company.demotrello.config.Temp;
import com.company.demotrello.dtos.project.board.BoardCreateDTO;
import com.company.demotrello.dtos.project.board.BoardDTO;
import com.company.demotrello.entities.project.Board;
import com.company.demotrello.entities.project.Workspace;
import com.company.demotrello.exceptions.GenericNotFoundException;
import com.company.demotrello.mappers.project.BoardMapper;
import com.company.demotrello.repository.project.BoardRepository;
import com.company.demotrello.repository.project.WorkspaceRepository;
import com.company.demotrello.response.project.board.BoardResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final WorkspaceRepository workspaceRepository;
    private final BoardMapper boardMapper;


    public BoardResponse<List<BoardDTO>, List<BoardDTO>> getAll() {
        List<Workspace> myWorkspaces = workspaceRepository.getWorkspacesByOwner(Temp.authUser);
        ArrayList<Board> myBoards = new ArrayList<>();
        myWorkspaces.forEach(workspace -> myBoards.addAll(workspace.getBoards()));
        // TODO: 9/5/2022 fix workspaceId
        // TODO: 9/5/2022 fix joinBoards

        return new BoardResponse<>(boardMapper.toDTO(myBoards), null);
    }

    public void create(BoardCreateDTO dto) {
        Supplier<GenericNotFoundException> notFoundException = () -> new GenericNotFoundException("Workspace not found", 404);
        Workspace workspace = workspaceRepository.findById(dto.getWorkspaceId()).orElseThrow(notFoundException);
        Board board = boardMapper.fromBoardCreateDTO(dto);
        board.setWorkspace(workspace);
        boardRepository.save(board);
    }

    public BoardDTO get(@NonNull Long id) {
        Supplier<GenericNotFoundException> notFoundException = () -> new GenericNotFoundException("Board not found", 404);
        Board board = boardRepository.findById(id).orElseThrow(notFoundException);
        return boardMapper.toDTO(board);
    }

    public void delete(@NonNull Long id) {
        boardRepository.deleteById(id);
    }


}
