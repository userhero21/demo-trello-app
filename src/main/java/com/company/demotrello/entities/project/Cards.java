package com.company.demotrello.entities.project;

import com.company.demotrello.entities.auth.AuthUser;
import com.company.demotrello.entities.base.Auditable;
import com.company.demotrello.entities.comment.Comments;
import com.company.demotrello.entities.utils.Labels;
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
public class Cards extends Auditable {

    private String name;

    private String description;

    @OneToMany(mappedBy = "card")
    private Collection<Checklists> checklists = new ArrayList<>();

    @OneToMany(mappedBy = "card")
    private Collection<Comments> comments = new ArrayList<>();

    @ManyToOne
    private Columns column;

    @ManyToMany
    @JoinTable(
//            name = "auth_user_cards",
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "auth_user_id"))
    private Collection<AuthUser> members = new ArrayList<>();

    @ManyToMany
    @JoinTable(
//            name = "auth_user_cards",
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id"))
    private Collection<Labels> labels = new ArrayList<>();

}
