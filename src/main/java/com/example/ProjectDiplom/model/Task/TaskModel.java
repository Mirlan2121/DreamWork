package com.example.ProjectDiplom.model.Task;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class TaskModel {

    private Long id;
    private String name;
    private String description;

    private Long client;
    private Long company;
    private Long typeCatalog;
    private Long workers;
}
