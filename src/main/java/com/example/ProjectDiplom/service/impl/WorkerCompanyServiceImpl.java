package com.example.ProjectDiplom.service.impl;

import com.example.ProjectDiplom.entity.WorkerCompany;
import com.example.ProjectDiplom.model.Workers.WorkerCompanyModel;
import com.example.ProjectDiplom.model.Workers.WorkersListModel;
import com.example.ProjectDiplom.repository.WorkerCompanyRepository;
import com.example.ProjectDiplom.service.CompanyService;
import com.example.ProjectDiplom.service.WorkerCompanyService;
import com.example.ProjectDiplom.service.WorkersInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerCompanyServiceImpl implements WorkerCompanyService {

    @Autowired
    private WorkerCompanyRepository workerCompanyRepository;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private WorkersInfoService workersInfoService;

    @Override
    public WorkerCompany save(WorkerCompanyModel workerCompanyModel) {

        WorkerCompany workerCompany = new WorkerCompany();

        workerCompany.setCompany(companyService.getByCompanyId(workerCompanyModel.getCompany()));

        workerCompany.setWorkersInfo(workersInfoService.getByWorkersId(workerCompanyModel.getWorkerId()));

        return workerCompanyRepository.save(workerCompany);
    }

    @Override
    public List<WorkerCompany> getAllUserCompany() {
        return workerCompanyRepository.findAll();
    }

    @Override
    public WorkerCompany getById(Long id) {
        return workerCompanyRepository.findById(id).orElse(null);
    }

    @Override
    public WorkerCompany getByCompanyId(Long id) {
        return workerCompanyRepository.findByCompanyId(id).orElse(null);
    }

    @Override
    public List<WorkerCompany> saveList(WorkersListModel workersListModel) {

        return null;
    }
}
