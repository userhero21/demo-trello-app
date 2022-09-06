package com.company.demotrello.dtos.project.card;

import com.company.demotrello.dtos.project.checklist.ChecklistDTO;
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
    private Long id;
    private String name;
    private String description;
    private Long columnId;
//    private List<ChecklistDTO> checklists;
//    private List<AuthUser> members;
//    private List<Comment> comments;
//    private List<Label> labels;
    // TODO: 9/6/2022 fix this
}
