package com.example.ProjectDiplom.model;


import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ClientInfoModel {

    private String name;
    private String serName;
    private String phone;
    private String address;
    private Double balance;
    private LocalDate dateOfBirth;
    private String email;
    private boolean gender;
}
