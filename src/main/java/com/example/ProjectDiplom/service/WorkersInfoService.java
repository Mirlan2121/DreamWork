package com.example.ProjectDiplom.service;

import com.example.ProjectDiplom.entity.User;
import com.example.ProjectDiplom.entity.WorkersInfo;
import com.example.ProjectDiplom.model.UserAuthModel;

import java.util.List;

public interface WorkersInfoService {

    List<WorkersInfo> create(WorkersInfo workersInfo);

    WorkersInfo getAll();

    WorkersInfo getByWorkersId(Long id);

    WorkersInfo getAuthorized(UserAuthModel userAuthModel);

    WorkersInfo getByWorkersName(String name);



}
