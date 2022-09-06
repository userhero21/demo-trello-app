package com.company.demotrello.dtos.project.workspace;

import com.company.demotrello.dtos.auth.MemberDTO;
import com.company.demotrello.dtos.project.board.BoardDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkspaceDTO {
    private long id;
    private String name;
    private String description;
    private List<BoardDTO> boards;
    private List<MemberDTO> members;
}
