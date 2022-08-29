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
public class Tasks extends Auditable {

    private String name;

    private boolean isCompleted;

    @ManyToMany
    @JoinTable(
//            name = "auth_user_cards",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "auth_user_id"))
    private Collection<AuthUser> members = new ArrayList<>();

    @OneToMany(mappedBy = "task")
    private Collection<Checklists> checklists = new ArrayList<>();

}
