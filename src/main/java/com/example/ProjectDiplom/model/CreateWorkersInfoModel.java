package com.example.ProjectDiplom.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateWorkersInfoModel {
    // создание работника паралелно с ним создается пользователь
    private String username;
    private String password;

    private String name;
    private String serName;
    private String userInfo;
    private LocalDate dateOfBirth;
    private String status;
    private Integer phone;
    private String type;
}
