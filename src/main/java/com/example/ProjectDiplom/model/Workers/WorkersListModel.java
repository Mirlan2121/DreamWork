package com.example.ProjectDiplom.model.Workers;

import com.example.ProjectDiplom.entity.WorkersInfo;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class WorkersListModel {
    private List<WorkersInfo> workerId;
    private Long company;
}
