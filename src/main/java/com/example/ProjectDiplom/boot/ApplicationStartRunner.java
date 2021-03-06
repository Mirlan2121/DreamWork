package com.example.ProjectDiplom.boot;

import com.example.ProjectDiplom.entity.User;
import com.example.ProjectDiplom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartRunner implements CommandLineRunner {


    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        if(userService.getByUsername("admin") == null) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword("1234");
            admin.setUserInfo("Администратор");
            admin.setActive(1L);
            userService.createAdmin(admin);
        }
    }
}
