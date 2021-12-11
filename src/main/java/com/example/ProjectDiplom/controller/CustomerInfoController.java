package com.example.ProjectDiplom.controller;

import com.example.ProjectDiplom.entity.CustomerInfo;
import com.example.ProjectDiplom.model.CreateCustomerModel;
import com.example.ProjectDiplom.model.CustomerInfoModel;
import com.example.ProjectDiplom.model.UserAuthModel;
import com.example.ProjectDiplom.repository.CustomerRepository;
import com.example.ProjectDiplom.service.CustomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customerInfo/")
public class CustomerInfoController {
    @Autowired
    private CustomInfoService customInfoService;
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/create")
    public CustomerInfo createCustomer(@RequestBody CreateCustomerModel createCustomerModel) {
        return customInfoService.customCreate(createCustomerModel);
    }

    @GetMapping
    public List<CustomerInfo>getAll(){
        return customInfoService.getAll();
    }

    @PostMapping("/customerName/{customerName}")
    public CustomerInfo getByCustomerName(@PathVariable String customerName){
        return customInfoService.getByCustomerName(customerName);
    }

    @PostMapping("/sing-in")
    public ResponseEntity<String> singIn(@RequestBody UserAuthModel userAuthModel){
        return ResponseEntity.ok(customInfoService.getAuthorization(userAuthModel));
    }

    @PostMapping("/getById/{id}")
    public CustomerInfo getById(@PathVariable Long id){
    return customInfoService.getByCustomerId(id);
    }

    @GetMapping("/get-current")
    public CustomerInfo getCurrent(){
        return customInfoService.getCurrentCustomer();
    }

}

