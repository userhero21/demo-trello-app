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
@Entity(name = "checklists")
public class Checklist extends Auditable {

    private String name;

    @ManyToOne
    private Card card;

    @ManyToOne
    private Task task;

}
