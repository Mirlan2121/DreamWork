package com.example.ProjectDiplom.controller;

import com.example.ProjectDiplom.entity.WorkerCompany;
import com.example.ProjectDiplom.model.Workers.WorkerCompanyModel;
import com.example.ProjectDiplom.service.WorkerCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/workerCompany")
public class WorkerCompanyController {


    private final WorkerCompanyService workerCompanyService;

    @PostMapping("/save")
    public WorkerCompany save(@RequestBody WorkerCompanyModel workerCompanyModel) {
        return workerCompanyService.save(workerCompanyModel);
    }

    @GetMapping("/getAllUserCompany")
    public List<WorkerCompany> getAllUserCompany() {
        return workerCompanyService.getAllUserCompany();
    }

    @GetMapping("/getById/{id}")
    public WorkerCompany getByUserId(@PathVariable Long id) {
        return workerCompanyService.getById(id);
    }

    @GetMapping("/getByCompanyId/{id}")
    public WorkerCompany getByCompanyId(@PathVariable Long id) {
        return workerCompanyService.getByCompanyId(id);
    }
}
