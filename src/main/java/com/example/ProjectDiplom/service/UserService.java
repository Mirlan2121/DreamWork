package com.example.ProjectDiplom.service;

import com.example.ProjectDiplom.entity.User;
import com.example.ProjectDiplom.model.UserAuthModel;

import java.util.List;

public interface UserService {
    User create(User user);

    List<User> getAll();

    User getCurrentUser();

    User getByUsername(String username);

    String getAuthorizationToken(UserAuthModel userAuthModel);
}
