package com.company.demotrello.entities.project;

import com.company.demotrello.entities.base.Auditable;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;

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

    @OneToMany(mappedBy = "checklist", fetch = FetchType.EAGER)
    private Collection<Task> tasks = new ArrayList<>();

}
