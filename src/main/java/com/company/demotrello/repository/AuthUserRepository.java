package com.company.demotrello.repository;

import com.company.demotrello.entities.auth.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    Optional<AuthUser> findByUsername(String username);

    Optional<AuthUser> findByEmail(String email);

    List<AuthUser> getAuthUsersByJoinCards_Id(Long cardId);

//    List<AuthUser> getAuthUsersByJoinWorkspaces_Id(Long joinWorkspaceId);
}
