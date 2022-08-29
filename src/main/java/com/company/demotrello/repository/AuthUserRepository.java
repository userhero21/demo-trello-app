package com.company.demotrello.repository;

import com.company.demotrello.entities.auth.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author "Elmurodov Javohir"
 * @since 19/08/22/12:09 (Friday)
 * spring-boot-features/IntelliJ IDEA
 */
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    Optional<AuthUser> findByUsername(String username);
}
