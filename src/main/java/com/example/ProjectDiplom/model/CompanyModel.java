package com.example.ProjectDiplom.model;

import com.example.ProjectDiplom.entity.TypeCatalog;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CompanyModel {

    private String name;
    private String description;
    private String address;
    private String email;
    private String phone;
    private Long typeCatalog;
}
