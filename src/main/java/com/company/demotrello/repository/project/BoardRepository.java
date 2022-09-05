package com.company.demotrello.repository.project;

import com.company.demotrello.entities.project.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> getBoardsByMembers_Id(long id);

}
