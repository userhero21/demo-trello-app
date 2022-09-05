package com.company.demotrello.dtos.project.column;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ColumnChangePositionDTO {
    private Long columnId;
    private int position;
}
