package com.example.ProjectDiplom.controller;

import com.example.ProjectDiplom.entity.Company;
import com.example.ProjectDiplom.model.CompanyModel;
import com.example.ProjectDiplom.model.CompanyUpdateModel;
import com.example.ProjectDiplom.service.CompanyService;
import com.example.ProjectDiplom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserService userService;

    @PostMapping("/createCompany")
    public Company save(@RequestBody CompanyModel companyModel){
        return companyService.create(companyModel);
    }

    @GetMapping("/getAll")
    public List<Company> getAll(){
        return companyService.getAllCompany();
    }

    @PostMapping("/getByCompanyId/{id}")
    public Company getByCompanyId(@PathVariable Long id){
        return companyService.getByCompanyId(id);
    }

    @DeleteMapping("/deleteCompany")
    public Company deleteCompany(){
        return companyService.deleteCompany();
    }
    @PostMapping("/updateCompany")
    public Company getUpdateCompany(@RequestBody CompanyUpdateModel companyUpdateModel){
        return companyService.getUpdateCompany(companyUpdateModel);
    }
}
