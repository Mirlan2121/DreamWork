package com.example.ProjectDiplom.service.impl;

import com.example.ProjectDiplom.entity.User;
import com.example.ProjectDiplom.entity.UserCompany;
import com.example.ProjectDiplom.model.UserCompanyModel;
import com.example.ProjectDiplom.repository.UserCompanyRepository;
import com.example.ProjectDiplom.service.CompanyService;
import com.example.ProjectDiplom.service.UserCompanyService;
import com.example.ProjectDiplom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCompanyServiceImpl implements UserCompanyService {

    @Autowired
    private UserCompanyRepository userCompanyRepository;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserService userService;

    @Override
    public UserCompany save(UserCompanyModel userCompanyModel) {

        User user = userService.getCurrentUser();

        UserCompany userCompany = new UserCompany();

        userCompany.setCompany(companyService.getByCompanyId(userCompanyModel.getCompany()));

        userCompany.setUser(userService.getByUserId(userCompanyModel.getUser()));

        return userCompanyRepository.save(userCompany);
    }

    @Override
    public List<UserCompany> getAllUserCompany() {
        return userCompanyRepository.findAll();
    }

    @Override
    public List<UserCompany> getByUserId(UserCompanyModel userCompanyModel) {
        return userCompanyRepository.findByUserId(userCompanyModel.getUser()).orElse(null);
    }

    @Override
    public UserCompany getByCompanyId(Long id) {
        return userCompanyRepository.findByCompanyId(id).orElse(null);
    }
}
