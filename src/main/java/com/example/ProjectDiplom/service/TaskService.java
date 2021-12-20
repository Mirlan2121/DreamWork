package com.example.ProjectDiplom.service;

import com.example.ProjectDiplom.entity.Task;
import com.example.ProjectDiplom.model.TaskModel;
import com.example.ProjectDiplom.model.TaskStatusModel;
import com.example.ProjectDiplom.model.TaskWorkersModel;

import java.util.List;

public interface TaskService {

    Task create(TaskModel taskModel);

    List<Task> getAllTasks();

    Task getUpdateStatus(TaskStatusModel taskStatusModel);

    Task getByIdTask(Long id);

    Task deleteTask(Long id);

    Task getWorkersUpdate(TaskWorkersModel taskWorkersModel);

}
