package com.example.ProjectDiplom.controller;

import com.example.ProjectDiplom.entity.User;
import com.example.ProjectDiplom.model.UserAuthModel;
import com.example.ProjectDiplom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

        @GetMapping("/get-current")
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }

    @PostMapping("/sign-in")
    public ResponseEntity<String> signIn(@RequestBody UserAuthModel userAuthModel) {
        return ResponseEntity.ok(userService.getAuthorizationToken(userAuthModel));
    }
}
