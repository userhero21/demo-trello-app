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
@Entity
public class Columns extends Auditable {

    private int orderNumber;

    @OneToMany(mappedBy = "column")
    private Collection<Cards> cards = new ArrayList<>();

    @ManyToOne
    private Boards board;


}
