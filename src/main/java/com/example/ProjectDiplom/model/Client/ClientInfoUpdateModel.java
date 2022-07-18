package com.example.ProjectDiplom.model.Client;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ClientInfoUpdateModel {

    private Long id;
    private String name;
    private String serName;
    private String phone;
    private String email;
    private String address;
    private Double balance;
    private boolean gender;
}
