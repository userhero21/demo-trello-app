package com.company.demotrello.entities.project;

import com.company.demotrello.entities.auth.AuthUser;
import com.company.demotrello.entities.base.Auditable;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Workspace extends Auditable {

    private String name;

    private String description;

    @OneToMany(mappedBy = "workspace", fetch = FetchType.EAGER)
    private Collection<Board> boards = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private AuthUser owner;

    @ManyToMany
    @JoinTable(
//            name = "auth_user_cards",
            joinColumns = @JoinColumn(name = "workspace_id"),
            inverseJoinColumns = @JoinColumn(name = "auth_user_id"))
    private Collection<AuthUser> members = new ArrayList<>();
}
