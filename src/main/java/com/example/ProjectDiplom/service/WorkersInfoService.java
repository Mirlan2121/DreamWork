package com.example.ProjectDiplom.service;

import com.example.ProjectDiplom.entity.WorkersInfo;

import java.util.List;

public interface WorkersInfoService {

    WorkersInfo createWorker(WorkersInfo workersInfo);

    List<WorkersInfo> getAll();

    WorkersInfo getByWorkersId(Long id);

    WorkersInfo getByWorkersName(String name);

    WorkersInfo getDeleteWorkers();
}

