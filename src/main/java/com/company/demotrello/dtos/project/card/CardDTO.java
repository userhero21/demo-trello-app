package com.company.demotrello.dtos.project.card;

import com.company.demotrello.dtos.auth.MemberDTO;
import com.company.demotrello.dtos.project.checklist.ChecklistDTO;
import com.company.demotrello.dtos.project.comment.CommentDTO;
import com.company.demotrello.dtos.project.label.LabelDTO;
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
    private List<ChecklistDTO> checklists;
    private List<MemberDTO> members;
    private List<CommentDTO> comments;
    private List<LabelDTO> labels;
}
