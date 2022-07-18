package com.example.ProjectDiplom.service;

import com.example.ProjectDiplom.entity.WorkersInfo;
import com.example.ProjectDiplom.model.Workers.WorkersInfoModel;
import com.example.ProjectDiplom.model.Workers.WorkersInfoUpdateModel;

import java.util.List;

public interface WorkersInfoService {

    WorkersInfo createWorker(WorkersInfoModel workersInfoModel);

    List<WorkersInfo> getAll();

    WorkersInfo getByWorkersId(Long id);

    WorkersInfo getByWorkersName(String name);

    WorkersInfo getDeleteWorkers();

    WorkersInfo getUpdateWorkers(WorkersInfoUpdateModel workersInfoUpdateModel);
}

