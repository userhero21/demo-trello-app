package com.company.demotrello.entities.utils;

import com.company.demotrello.entities.base.Auditable;
import com.company.demotrello.entities.project.Cards;
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
@Entity
public class Labels extends Auditable {

    private String name;

    private String color;

    @ManyToMany
    @JoinTable(
//            name = "auth_user_cards",
            joinColumns = @JoinColumn(name = "label_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id"))
    private Collection<Cards> cards = new ArrayList<>();

}
