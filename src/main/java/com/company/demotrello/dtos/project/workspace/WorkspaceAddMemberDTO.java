package com.company.demotrello.dtos.project.workspace;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkspaceAddMemberDTO {
    private Long workspaceId;
    private String emailOrUsername;
}
