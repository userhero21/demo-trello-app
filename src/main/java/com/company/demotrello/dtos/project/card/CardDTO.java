package com.company.demotrello.dtos.project.card;

import com.company.demotrello.entities.auth.AuthUser;
import com.company.demotrello.entities.comment.Comment;
import com.company.demotrello.entities.project.Checklist;
import com.company.demotrello.entities.utils.Label;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardDTO {
    private String name;
    private String description;
    private List<Checklist> checklists;
    private List<AuthUser> members;
    private List<Comment> comments;
    private List<Label> labels;
}
