package com.company.demotrello.entities.comment;

import com.company.demotrello.entities.auth.AuthUser;
import com.company.demotrello.entities.base.Auditable;
import com.company.demotrello.entities.project.Card;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "comments")
public class Comment extends Auditable {

    private String title;

    @ManyToOne
    private AuthUser authUser;

    @ManyToOne
    private Card card;

}
