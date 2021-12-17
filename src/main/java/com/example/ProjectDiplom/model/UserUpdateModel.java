package com.example.ProjectDiplom.model;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserUpdateModel {

    private Long id;
    private String oldPassword;
    private String newPassword;

}
