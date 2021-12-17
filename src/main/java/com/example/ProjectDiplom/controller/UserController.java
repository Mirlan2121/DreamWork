package com.example.ProjectDiplom.controller;

import com.example.ProjectDiplom.entity.User;
import com.example.ProjectDiplom.model.UserAuthModel;
import com.example.ProjectDiplom.model.UserUpdateModel;
import com.example.ProjectDiplom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/get-current")
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }

    @PostMapping("/getByUserId/{id}")
    public User getByUserId(@PathVariable Long id){
        return userService.getByUserId(id);
    }

    @PostMapping("/sing-in")
    public ResponseEntity<String> singIn(@RequestBody UserAuthModel userAuthModel) {
        return ResponseEntity.ok(userService.getAuthorizationToken(userAuthModel));
    }

    @DeleteMapping("/deleteUser")
    public User deleteUser(){
        return userService.deleteUser(userService.getCurrentUser());
    }
    @PostMapping("/updateUser")
    public User updateUser(@RequestBody UserUpdateModel userUpdateModel){
        return userService.getUpdateUser(userUpdateModel);
    }

}
