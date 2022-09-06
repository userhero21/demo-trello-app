package com.company.demotrello.repository.project;

import com.company.demotrello.entities.utils.Label;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LabelRepository extends JpaRepository<Label, Long> {

    List<Label> getLabelsByCards_Id(Long cardId);

}
