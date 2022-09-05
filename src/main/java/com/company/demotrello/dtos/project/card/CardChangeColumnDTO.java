package com.company.demotrello.dtos.project.card;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardChangeColumnDTO {
    private Long cardId;
    private Long columnId;
}
