package com.company.demotrello.dtos.project.workspace;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkspaceUpdateDTO {
    private Long workspaceId;
    private String name;
    private String description;
}
