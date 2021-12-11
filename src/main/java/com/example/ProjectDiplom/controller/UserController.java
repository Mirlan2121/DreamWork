package com.example.ProjectDiplom.controller;

import com.example.ProjectDiplom.entity.User;
import com.example.ProjectDiplom.model.UserAuthModel;
import com.example.ProjectDiplom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        return userService.getAllUsers();
    }

    @PostMapping("/log-in")
    public User getUser(@RequestBody UserAuthModel userAuthModel) {
        return userService.getAuthorized(userAuthModel);
    }


    @GetMapping("/get-current")
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }

    @PostMapping("/getByUserId/{id}")
    public User getByUserId(@PathVariable Long id){
        return userService.getByUserId(id);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<String> signIn(@RequestBody UserAuthModel userAuthModel) {
        return ResponseEntity.ok(userService.getAuthorizationToken(userAuthModel));
    }

}
