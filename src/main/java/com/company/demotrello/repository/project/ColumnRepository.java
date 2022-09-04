package com.company.demotrello.repository.project;

import com.company.demotrello.entities.project.Column;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColumnRepository extends JpaRepository<Column, Long> {
}
