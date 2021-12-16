package com.example.ProjectDiplom.service;

import com.example.ProjectDiplom.entity.Company;
import com.example.ProjectDiplom.entity.User;

import java.util.List;

public interface CompanyService {

    Company create (Company company);

    List<Company> getAllCompany();

    Company getByCompanyId(Long id);

    Company deleteCompany();

}
