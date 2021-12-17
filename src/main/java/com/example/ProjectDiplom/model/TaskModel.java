package com.example.ProjectDiplom.model;


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
}
