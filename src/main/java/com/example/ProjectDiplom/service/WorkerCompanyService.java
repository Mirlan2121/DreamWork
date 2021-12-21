package com.example.ProjectDiplom.service;

import com.example.ProjectDiplom.entity.WorkerCompany;
import com.example.ProjectDiplom.model.UserCompanyModel;

import java.util.List;

public interface WorkerCompanyService {

    WorkerCompany save(UserCompanyModel userCompany);

    List<WorkerCompany> getAllUserCompany();

    List<WorkerCompany> getByUserId(UserCompanyModel userCompanyModel);

    WorkerCompany getByCompanyId(Long id);
}
