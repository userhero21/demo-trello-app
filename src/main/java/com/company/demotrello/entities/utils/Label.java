package com.company.demotrello.entities.utils;

import com.company.demotrello.entities.base.Auditable;
import com.company.demotrello.entities.project.Card;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "labels")
public class Label extends Auditable {

    private String name;

    private String color;

    @ManyToMany
    @JoinTable(
//            name = "auth_user_cards",
            joinColumns = @JoinColumn(name = "label_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id"))
    private Collection<Card> cards = new ArrayList<>();

}
