package com.company.demotrello.repository;

import com.company.demotrello.entities.auth.AuthUser;
import com.company.demotrello.entities.project.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {
    List<Workspace> getWorkspacesByOwner(AuthUser owner);
}
