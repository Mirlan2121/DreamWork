package com.example.ProjectDiplom.controller;

import com.example.ProjectDiplom.entity.UserCompany;
import com.example.ProjectDiplom.model.UserCompanyModel;
import com.example.ProjectDiplom.service.UserCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userCompany")
public class UserCompanyController {

    @Autowired
    private UserCompanyService userCompanyService;

    @PostMapping("/save")
    public UserCompany save(UserCompanyModel userCompanyModel){
        return userCompanyService.save(userCompanyModel);
    }

    @GetMapping("/getAllUserCompany")
    public List<UserCompany> getAllUserCompany(){
        return userCompanyService.getAllUserCompany();
    }
    @PostMapping("/getByUserId")
    public List<UserCompany> getByUserId(@RequestBody UserCompanyModel userCompanyModel){

        return userCompanyService.getByUserId(userCompanyModel);
    }
    @PostMapping("/getByCompanyId")
    public UserCompany getByCompanyId(@PathVariable Long id){
        return userCompanyService.getByCompanyId(id);
    }
}
