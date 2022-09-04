package com.company.demotrello.config;

import com.company.demotrello.config.security.UserDetails;
import com.company.demotrello.entities.auth.AuthUser;
import org.springframework.security.core.context.SecurityContextHolder;

public interface Temp {
    AuthUser authUser = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).authUser();

}
