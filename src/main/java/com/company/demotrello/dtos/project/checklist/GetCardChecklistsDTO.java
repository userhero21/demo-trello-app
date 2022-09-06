package com.company.demotrello.dtos.project.checklist;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetCardChecklistsDTO {
    private Long cardId;
}
