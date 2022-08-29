package com.company.demotrello.entities.auth;

import com.company.demotrello.entities.base.Auditable;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class AuthPermission extends Auditable implements GrantedAuthority {

    private String name;

    private String code;

    @Override
    public String getAuthority() {
        return this.code;
    }
}
