package com.company.demotrello.repository;

import com.company.demotrello.entities.project.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {
}
