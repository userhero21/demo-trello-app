package com.company.demotrello.dtos.project.task;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDTO {
    private String name;
    private boolean isCompleted;
}
