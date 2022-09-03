package com.company.demotrello.repository;

import com.company.demotrello.entities.project.Boards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Boards, Long> {


}
