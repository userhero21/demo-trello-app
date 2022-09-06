package com.company.demotrello.dtos.project.label;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LabelDTO {
    private String name;
    private String color;
}
