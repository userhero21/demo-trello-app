package com.company.demotrello.repository.project;

import com.company.demotrello.entities.auth.AuthUser;
import com.company.demotrello.entities.project.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {
    List<Workspace> getWorkspacesByOwner(AuthUser owner);

    List<Workspace> getWorkspacesByMembers_Id(long id);

    Optional<Workspace> getWorkspaceByIdAndOwner(long id, AuthUser owner);

}
