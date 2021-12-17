package com.example.ProjectDiplom.service;

import com.example.ProjectDiplom.entity.WorkersInfo;
import com.example.ProjectDiplom.model.WorkersInfoModel;
import com.example.ProjectDiplom.model.WorkersInfoUpdateModel;

import java.util.List;

public interface WorkersInfoService {

    WorkersInfo createWorker(WorkersInfoModel workersInfoModel);

    List<WorkersInfo> getAll();

    WorkersInfo getByWorkersId(Long id);

    WorkersInfo getByWorkersName(String name);

    WorkersInfo getDeleteWorkers();

    WorkersInfo getUpdateWorkers(WorkersInfoUpdateModel workersInfoUpdateModel);
}

