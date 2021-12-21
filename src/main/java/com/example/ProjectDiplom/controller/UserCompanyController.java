package com.example.ProjectDiplom.controller;

import com.example.ProjectDiplom.entity.WorkerCompany;
import com.example.ProjectDiplom.model.UserCompanyModel;
import com.example.ProjectDiplom.service.WorkerCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userCompany")
public class UserCompanyController {

    @Autowired
    private WorkerCompanyService workerCompanyService;

    @PostMapping("/save")
    public WorkerCompany save(@RequestBody UserCompanyModel userCompanyModel){
        return workerCompanyService.save(userCompanyModel);
    }

    @GetMapping("/getAllUserCompany")
    public List<WorkerCompany> getAllUserCompany(){
        return workerCompanyService.getAllUserCompany();
    }
    @PostMapping("/getByUserId")
    public List<WorkerCompany> getByUserId(@RequestBody UserCompanyModel userCompanyModel){

        return workerCompanyService.getByUserId(userCompanyModel);
    }
    @PostMapping("/getByCompanyId")
    public WorkerCompany getByCompanyId(@PathVariable Long id){
        return workerCompanyService.getByCompanyId(id);
    }
}
