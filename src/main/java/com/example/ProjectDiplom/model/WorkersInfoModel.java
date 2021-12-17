package com.example.ProjectDiplom.model;


import com.example.ProjectDiplom.entity.TypeCatalog;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class WorkersInfoModel {
    private String name;
    private String serName;
    private String phone;
    private String address;
    private String email;
    private LocalDate dateOfBirth;
    private boolean gender;
    private Long typeCatalog;
}
