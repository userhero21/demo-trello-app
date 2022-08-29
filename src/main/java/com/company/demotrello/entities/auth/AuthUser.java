package com.company.demotrello.entities.auth;

import com.company.demotrello.entities.base.Auditable;
import com.company.demotrello.entities.project.Cards;
import com.company.demotrello.entities.project.Tasks;
import com.company.demotrello.entities.project.Workspace;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class AuthUser extends Auditable {

    private String username;

    private String password;

    private String email;

    private LocalDateTime lastLoginTime;

    private int loginTryCount;

    @Builder.Default
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.NOT_ACTIVE;

    @OneToMany(mappedBy = "owner")
    private Collection<Workspace> workspaces = new ArrayList<>();

    @ManyToMany
    @JoinTable(
//            name = "auth_user_cards",
            joinColumns = @JoinColumn(name = "auth_user_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    private Collection<Tasks> tasks = new ArrayList<>();

    @ManyToMany
    @JoinTable(
//            name = "auth_user_cards",
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "auth_user_id"))
    private Collection<Cards> cards = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
//            name = "auth_user_auth_role",
            joinColumns = @JoinColumn(name = "auth_user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "auth_role_id", referencedColumnName = "id")
    )
    private Collection<AuthRole> roles;


    public enum Status {
        ACTIVE, NOT_ACTIVE, BLOCKED,
    }

    public boolean isActive() {
        return Status.ACTIVE.equals(this.status);
    }


}
