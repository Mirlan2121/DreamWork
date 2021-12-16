package com.example.ProjectDiplom.model;

import com.example.ProjectDiplom.entity.TaskStatus;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class TaskModel {
    private String name;
    private String description;


}
