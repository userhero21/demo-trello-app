package com.company.demotrello.entities.project;

import com.company.demotrello.entities.auth.AuthUser;
import com.company.demotrello.entities.base.Auditable;
import com.company.demotrello.entities.comment.Comment;
import com.company.demotrello.entities.utils.Label;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "cards")
public class Card extends Auditable {

    private String name;

    private String description;

    @OneToMany(mappedBy = "card")
//    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<Checklist> checklists = new ArrayList<>();

    @OneToMany(mappedBy = "card")
//    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<Comment> comments = new ArrayList<>();

    @ManyToOne
    private Column column;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "auth_user_id"))
//    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<AuthUser> members = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id"))
//    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<Label> labels = new ArrayList<>();

}
