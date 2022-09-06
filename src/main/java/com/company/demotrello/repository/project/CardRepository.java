package com.company.demotrello.repository.project;

import com.company.demotrello.entities.project.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {
}
