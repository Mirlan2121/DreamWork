package com.example.ProjectDiplom.model.Company;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CompanyUpdateModel {
    private Long id;
    private String name;
    private String description;
    private String address;
    private String email;
    private String phone;
    private Long typeCatalog;
}
