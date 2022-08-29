package com.company.demotrello.entities.comment;

import com.company.demotrello.entities.auth.AuthUser;
import com.company.demotrello.entities.base.Auditable;
import com.company.demotrello.entities.project.Cards;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Comments extends Auditable {

    private String title;

    @ManyToOne
    private AuthUser authUser;

    @ManyToOne
    private Cards card;

}
