package com.example.ProjectDiplom.service;

import com.example.ProjectDiplom.entity.WorkerCompany;
import com.example.ProjectDiplom.model.Workers.WorkerCompanyModel;
import com.example.ProjectDiplom.model.Workers.WorkersListModel;

import java.util.List;

public interface WorkerCompanyService {

    WorkerCompany save(WorkerCompanyModel userCompany);

    List<WorkerCompany> getAllUserCompany();

    WorkerCompany getById(Long id);

    WorkerCompany getByCompanyId(Long id);

    List<WorkerCompany> saveList(WorkersListModel workersListModel);
}
