package com.company.demotrello.dtos.project.column;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ColumnCreateDTO {
    private String name;
    private long boardId;
}
