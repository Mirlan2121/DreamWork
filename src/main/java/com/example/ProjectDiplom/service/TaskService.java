package com.example.ProjectDiplom.service;

import com.example.ProjectDiplom.entity.Task;
import com.example.ProjectDiplom.model.Task.TaskModel;
import com.example.ProjectDiplom.model.Task.TaskStatusModel;
import com.example.ProjectDiplom.model.Task.TaskWorkersModel;

import java.util.List;

public interface TaskService {

    Task create(TaskModel taskModel);

    List<Task> getAllTasks();

    Task getUpdateStatus(TaskStatusModel taskStatusModel);

    Task getByIdTask(Long id);

    Task deleteTask(Long id);

    Task getWorkersUpdate(TaskWorkersModel taskWorkersModel);

}
