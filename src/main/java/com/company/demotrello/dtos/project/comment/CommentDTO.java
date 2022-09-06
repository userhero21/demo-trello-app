package com.company.demotrello.dtos.project.comment;

import com.company.demotrello.dtos.auth.MemberDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDTO {
    private String title;
    private MemberDTO from;
}
