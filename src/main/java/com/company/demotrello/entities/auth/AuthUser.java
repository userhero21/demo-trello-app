package com.company.demotrello.entities.auth;

import com.company.demotrello.entities.base.Auditable;
import com.company.demotrello.entities.project.Card;
import com.company.demotrello.entities.project.Task;
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


    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "auth_user_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    private Collection<Task> tasks = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "auth_user_id"))
    private Collection<Card> cards = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = @JoinColumn(name = "auth_user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "auth_role_id", referencedColumnName = "id"))
    private Collection<AuthRole> roles;

    @ManyToMany(mappedBy = "members")
    private Collection<Workspace> joinWorkspaces = new ArrayList<>();

    @ManyToMany(mappedBy = "members")
    private Collection<Card> joinCards = new ArrayList<>();

    public enum Status {
        ACTIVE, NOT_ACTIVE, BLOCKED,
    }

    public boolean isActive() {
        return Status.ACTIVE.equals(this.status);
    }


}
