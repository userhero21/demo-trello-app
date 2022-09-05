package com.company.demotrello.dtos.project.card;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardCreateDTO {
    private String name;
    private String description;
    private Long columnId;
}
