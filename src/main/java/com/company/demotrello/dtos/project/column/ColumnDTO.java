package com.company.demotrello.dtos.project.column;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ColumnDTO {
    private Long id;
    private String name;
    private int position;
}
