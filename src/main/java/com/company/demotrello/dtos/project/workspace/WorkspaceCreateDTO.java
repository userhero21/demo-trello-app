package com.company.demotrello.dtos.project.workspace;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkspaceCreateDTO {
    private String name;
    private String description;
}
