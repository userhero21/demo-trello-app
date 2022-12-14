package com.company.demotrello.dtos.project.board;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardCreateDTO {
    private String name;
    private String description;
    private Long workspaceId;
}
