package com.example.ProjectDiplom.service.impl;

import com.example.ProjectDiplom.entity.CustomerInfo;
import com.example.ProjectDiplom.entity.User;
import com.example.ProjectDiplom.entity.UserRole;
import com.example.ProjectDiplom.model.CreateCustomerModel;
import com.example.ProjectDiplom.model.UserAuthModel;
import com.example.ProjectDiplom.repository.CustomerRepository;
import com.example.ProjectDiplom.repository.UserRepository;
import com.example.ProjectDiplom.repository.UserRoleRepository;
import com.example.ProjectDiplom.service.CustomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class CustomInfoServiceImpl implements CustomInfoService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public CustomerInfo customCreate(CreateCustomerModel createCustomerModel) {

        User user = new User();
        user.setUsername(createCustomerModel.getUsername());
        String encodedPassword = passwordEncoder.encode(createCustomerModel.getPassword());
        user.setPassword(encodedPassword);
        user.setUserInfo("Клиент");
        user.setActive(1L);
        user = userRepository.save(user);

        UserRole userRole = new UserRole();
        userRole.setRoleName("ROLE_CUSTOMER");
        userRole.setUser(user);
        userRoleRepository.save(userRole);

        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setBalance(0.0);
        customerInfo.setName(createCustomerModel.getName());
        customerInfo.setSerName(createCustomerModel.getSerName());
        customerInfo.setDateOfBirth(createCustomerModel.getDateOfBirth());
        customerInfo.setPhone(createCustomerModel.getPhone());
        customerInfo.setStatus(createCustomerModel.getStatus());
        customerInfo.setUser(user);
        customerRepository.save(customerInfo);

        return customerInfo;
    }


    @Override
    public List<CustomerInfo> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerInfo getByCustomerId(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public CustomerInfo getCurrentUser() {
        String customerName = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByCustomerName(customerName);
    }

    @Override
    public CustomerInfo getCurrentCustomer(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return customerRepository.findByUser_username(username).orElse(null);
    }

    @Override
    public CustomerInfo getByCustomerName(String customerName) {
        return customerRepository.findByName(customerName).orElse(null);
    }

    @Override
    public String getAuthorization(UserAuthModel userAuthModel) {
        User user = userRepository.findByUsername(userAuthModel.getUsername()).orElseThrow
                (() -> new IllegalArgumentException("Неверный логин или пароль"));

        boolean isPasswordMatches = passwordEncoder.matches(userAuthModel.getPassword(), user.getPassword());
        if (!isPasswordMatches) {
            throw new IllegalArgumentException("Неверный логин или пароль");
        }

        String usernamePasswordPair = userAuthModel.getUsername() + ":" +userAuthModel.getPassword();
        return "Basic" + new String(Base64.getEncoder().encode(usernamePasswordPair.getBytes()));
    }
}
