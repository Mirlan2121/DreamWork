package com.example.ProjectDiplom.service;

import com.example.ProjectDiplom.entity.Company;
import com.example.ProjectDiplom.model.Company.CompanyModel;
import com.example.ProjectDiplom.model.Company.CompanyUpdateModel;

import java.util.List;

public interface CompanyService {

    Company create (CompanyModel companyModel);

    List<Company> getAllCompany();

    Company getByCompanyId(Long id);

    Company deleteCompany(Long id);

    Company getUpdateCompany(CompanyUpdateModel companyUpdateModel);
}
