package com.example.ProjectDiplom.service;

import com.example.ProjectDiplom.entity.CustomerInfo;
import com.example.ProjectDiplom.entity.User;
import com.example.ProjectDiplom.model.CreateCustomerModel;
import com.example.ProjectDiplom.model.UserAuthModel;

import java.util.List;

public interface CustomInfoService {
    CustomerInfo customCreate(CreateCustomerModel createCustomerModel);

    List<CustomerInfo> getAll();

    CustomerInfo getByCustomerId(Long id);

    CustomerInfo getCurrentUser();

    CustomerInfo getCurrentCustomer();

    CustomerInfo getByCustomerName(String customerName);

    String getAuthorization(UserAuthModel userAuthModel);
}
