package com.example.ProjectDiplom.service.impl;

import com.example.ProjectDiplom.entity.WorkerCompany;
import com.example.ProjectDiplom.model.UserCompanyModel;
import com.example.ProjectDiplom.repository.UserCompanyRepository;
import com.example.ProjectDiplom.service.CompanyService;
import com.example.ProjectDiplom.service.WorkerCompanyService;
import com.example.ProjectDiplom.service.WorkersInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerCompanyServiceImpl implements WorkerCompanyService {

    @Autowired
    private UserCompanyRepository userCompanyRepository;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private WorkersInfoService workersInfoService;

    @Override
    public WorkerCompany save(UserCompanyModel userCompanyModel) {

        WorkerCompany workerCompany = new WorkerCompany();

        workerCompany.setCompany(companyService.getByCompanyId(userCompanyModel.getCompany()));

        workerCompany.setWorkersInfo(workersInfoService.getByWorkersId(userCompanyModel.getWorkerId()));

        return userCompanyRepository.save(workerCompany);
    }

    @Override
    public List<WorkerCompany> getAllUserCompany() {
        return userCompanyRepository.findAll();
    }

    @Override
    public List<WorkerCompany> getByUserId(UserCompanyModel userCompanyModel) {
        return userCompanyRepository.findByUserId(userCompanyModel.getWorkerId()).orElse(null);
    }

    @Override
    public WorkerCompany getByCompanyId(Long id) {
        return userCompanyRepository.findByCompanyId(id).orElse(null);
    }
}
