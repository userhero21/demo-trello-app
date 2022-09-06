package com.company.demotrello.dtos.project.checklist;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChecklistCreateDTO {
    private String name;
    private Long cardId;
}
