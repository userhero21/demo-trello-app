package com.company.demotrello.repository.project;

import com.company.demotrello.entities.project.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {


}
