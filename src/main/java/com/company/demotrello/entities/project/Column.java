package com.company.demotrello.entities.project;

import com.company.demotrello.entities.base.Auditable;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "columns")
public class Column extends Auditable {

    private String name;

    private int position;

    @OneToMany(mappedBy = "column")
    private Collection<Card> cards = new ArrayList<>();

    @ManyToOne
    private Board board;


}
