package com.example.ProjectDiplom.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserAuthModel {
    private String username;
    private String password;

}
