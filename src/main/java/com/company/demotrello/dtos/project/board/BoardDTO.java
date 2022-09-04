package com.company.demotrello.dtos.project.board;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDTO {
    private long id;
    private String name;
    private String description;
    private Long workspaceId;
}
