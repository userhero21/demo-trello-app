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
@Entity(name = "boards")
public class Board extends Auditable {

    private String name;

    private String description;

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    private Collection<Column> columns = new ArrayList<>();

    @ManyToOne
    private Workspace workspace;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "board_id"),
            inverseJoinColumns = @JoinColumn(name = "auth_user_id"))
    private Collection<AuthUser> members = new ArrayList<>();



}
