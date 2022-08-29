package com.company.demotrello.entities.project;

import com.company.demotrello.entities.base.Auditable;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Checklists extends Auditable {

    private String name;

    @ManyToOne
    private Cards card;

    @ManyToOne
    private Tasks task;

}
