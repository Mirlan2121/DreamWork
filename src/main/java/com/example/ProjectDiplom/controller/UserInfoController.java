package com.example.ProjectDiplom.controller;

import com.example.ProjectDiplom.entity.CustomerInfo;
import com.example.ProjectDiplom.entity.User;
import com.example.ProjectDiplom.model.CreateCustomerModel;
import com.example.ProjectDiplom.model.CustomerInfoModel;
import com.example.ProjectDiplom.model.UserAuthModel;
import com.example.ProjectDiplom.service.CustomInfoService;
import com.example.ProjectDiplom.service.UserService;
import com.example.ProjectDiplom.service.impl.CustomInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customerInfo/")
public class UserInfoController {
    @Autowired
    private CustomInfoService customInfoService;

    @PostMapping("/create")
    public CustomerInfo createCustomer(@RequestBody CreateCustomerModel createCustomerModel) {
        return customInfoService.customCreate(createCustomerModel);
    }
    @GetMapping
    public List<CustomerInfo>getAll(){
        return customInfoService.getAll();
    }
    @GetMapping("/get-customer")
    public CustomerInfo getCurrentCustomer(){
        return customInfoService.getCurrentCustom();
    }
    @PostMapping("/sing-in")
    public ResponseEntity<String> singIn(@RequestBody UserAuthModel userAuthModel){
        return ResponseEntity.ok(customInfoService.getAuthorizationToken(userAuthModel));
    }
}
