package com.example.ProjectDiplom.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkersInfoModel {
    private String name;
    private String serName;
    private String status;
    private String type;
}
