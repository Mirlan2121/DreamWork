package com.example.ProjectDiplom.service;

import com.example.ProjectDiplom.entity.UserCompany;
import com.example.ProjectDiplom.model.UserCompanyModel;

import java.util.List;

public interface UserCompanyService {

    UserCompany save(UserCompanyModel userCompany);

    List<UserCompany> getAllUserCompany();

    List<UserCompany> getByUserId(UserCompanyModel userCompanyModel);

    UserCompany getByCompanyId(Long id);
}
