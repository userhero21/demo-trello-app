package com.company.demotrello.repository.project;

import com.company.demotrello.entities.project.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChecklistRepository extends JpaRepository<Checklist, Long> {
    List<Checklist> getChecklistsByCardId(Long cardId);
}
