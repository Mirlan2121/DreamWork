package com.example.ProjectDiplom.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class WorkersInfoUpdateModel {
    private Long id;
    private String name;
    private String serName;
    private String phone;
    private String address;
    private String email;
    private boolean gender;
}
