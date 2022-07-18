package com.example.ProjectDiplom.model.User;

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
