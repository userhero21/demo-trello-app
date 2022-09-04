package com.company.demotrello.repository.auth;

import com.company.demotrello.entities.auth.AuthRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRoleRepository extends JpaRepository<AuthRole, Long> {
}
