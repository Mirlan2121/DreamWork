package com.example.ProjectDiplom.service.impl;

import com.example.ProjectDiplom.entity.User;
import com.example.ProjectDiplom.entity.UserRole;
import com.example.ProjectDiplom.model.UserAuthModel;
import com.example.ProjectDiplom.repository.UserRepository;
import com.example.ProjectDiplom.repository.UserRoleRepository;
import com.example.ProjectDiplom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public User create(User user) {

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        System.out.println(encodedPassword);
        user.setPassword(encodedPassword);
        user.setActive(1L);
        userRepository.save(user);

        UserRole userRole = new UserRole();
        userRole.setRoleName("ROLE_USER");
        userRole.setUser(user);
        userRoleRepository.save(userRole);
        return user;
    }

    @Override
    public User  createAdmin(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        System.out.println(encodedPassword);
        user.setPassword(encodedPassword);
        user.setActive(1L);
        userRepository.save(user);

        UserRole userRole = new UserRole();
        userRole.setRoleName("ROLE_ADMIN");
        userRole.setUser(user);
        userRoleRepository.save(userRole);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getByUserId(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getAuthorized(UserAuthModel userAuthModel) {
        User user = getByUsername(userAuthModel.getUsername());
        if (!user.getPassword().equals(userAuthModel.getPassword())) {
            user = null;
        }
        return user;
    }


    @Override
    public User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }

    @Override
    public User deleteUser(User user) {
        UserRole userRoleDelete = userRoleRepository.findByUser(user).orElse(null);
        if (userRoleDelete == null){
            try {
                throw new Exception("Роли нет");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        userRoleRepository.delete(userRoleDelete);
        userRepository.delete(user);
        return user;
    }


    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }


    @Override
    public String getAuthorizationToken(UserAuthModel userAuthModel) {
        User user = userRepository.findByUsername(userAuthModel.getUsername()).orElseThrow
                (() -> new IllegalArgumentException("Неверный логин или пароль1"));

        boolean isPasswordMatches = passwordEncoder.matches(userAuthModel.getPassword(), user.getPassword());
        if (!isPasswordMatches) {
            throw new IllegalArgumentException("Неверный логин или пароль2");
        }

        String usernamePasswordPair = userAuthModel.getUsername() + ":" + userAuthModel.getPassword();
        return "Basic " + new String(Base64.getEncoder().encode(usernamePasswordPair.getBytes()));

    }

}
