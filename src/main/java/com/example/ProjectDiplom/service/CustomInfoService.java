package com.example.ProjectDiplom.service;

import com.example.ProjectDiplom.entity.CustomerInfo;
import com.example.ProjectDiplom.entity.User;
import com.example.ProjectDiplom.model.CreateCustomerModel;
import com.example.ProjectDiplom.model.UserAuthModel;

import java.util.List;

public interface CustomInfoService {
    CustomerInfo customCreate(CreateCustomerModel createCustomerModel);

    CustomerInfo delete (User user);

    List<CustomerInfo> getAll();

    CustomerInfo getCurrentCustom();

    CustomerInfo getByCustomerName(String customerName);

    String getAuthorizationToken(UserAuthModel userAuthModel);
}
