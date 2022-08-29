package com.company.demotrello.repository.auth;

import com.company.demotrello.entities.auth.AuthRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author "Elmurodov Javohir"
 * @since 19/08/22/15:51 (Friday)
 * spring-boot-features/IntelliJ IDEA
 */
public interface AuthRoleRepository extends JpaRepository<AuthRole, Long> {
}
