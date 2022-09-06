package com.company.demotrello.dtos.project.checklist;

import com.company.demotrello.dtos.project.task.TaskDTO;
import com.company.demotrello.entities.project.Task;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChecklistDTO {
    private String name;
    private List<TaskDTO> tasks;
}
