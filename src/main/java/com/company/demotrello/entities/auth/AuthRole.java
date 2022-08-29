package com.company.demotrello.entities.auth;

import com.company.demotrello.entities.base.Auditable;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class AuthRole extends Auditable implements GrantedAuthority {

    private String name;

    private String code;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
//            name = "auth_role_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Collection<AuthPermission> permissions;

    @Override
    public String getAuthority() {
        return null;
    }
}
