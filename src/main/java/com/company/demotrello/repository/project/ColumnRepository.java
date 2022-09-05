package com.company.demotrello.repository.project;

import com.company.demotrello.entities.project.Board;
import com.company.demotrello.entities.project.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ColumnRepository extends JpaRepository<Column, Long> {

    @Query(value = "SELECT max(position) FROM columns WHERE board = :board")
    int getMaxPosition(Board board);

    Optional<Column> getColumnByPosition(int position);
}
