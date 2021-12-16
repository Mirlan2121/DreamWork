package com.example.ProjectDiplom.service.impl;

import com.example.ProjectDiplom.entity.Company;
import com.example.ProjectDiplom.entity.User;
import com.example.ProjectDiplom.repository.CompanyRepository;
import com.example.ProjectDiplom.repository.UserRepository;
import com.example.ProjectDiplom.service.CompanyService;
import com.example.ProjectDiplom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @Override
    public Company create(Company company) {
        company.setUser(userService.getCurrentUser());
        return companyRepository.save(company);
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Company getByCompanyId(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Компания с таким ID нету в БАЗА ДАННЫХ!!!!"));
    }

    @Override
    public Company deleteCompany() {
        User user = userService.getCurrentUser();
        Company company = companyRepository.findByUser(user).orElse(null);
        companyRepository.delete(company);
        return company;
    }
}
