package com.example.ProjectDiplom.service.impl;

import com.example.ProjectDiplom.entity.ClientInfo;
import com.example.ProjectDiplom.entity.Task;
import com.example.ProjectDiplom.entity.TaskStatus;
import com.example.ProjectDiplom.entity.User;
import com.example.ProjectDiplom.model.TaskModel;
import com.example.ProjectDiplom.model.TaskStatusModel;
import com.example.ProjectDiplom.repository.ClientRepository;
import com.example.ProjectDiplom.repository.TaskRepository;
import com.example.ProjectDiplom.service.TaskService;
import com.example.ProjectDiplom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Task create(TaskModel taskModel) {
        User user =  userService.getCurrentUser();
        Task task = new Task();
        task.setName(taskModel.getName());
        task.setDescription(taskModel.getDescription());
        task.setClientInfo(task.getClientInfo());
        task.setTaskStatus(TaskStatus.NEW_OPEN);
        task.setClientInfo(clientRepository.findByUser_username(user.getUsername()).orElse(null));
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getUpdateStatus(TaskStatusModel taskStatusModel) {
        Task task = taskRepository.findById(taskStatusModel.getId()).orElse(null);
        task.setTaskStatus(taskStatusModel.getTaskStatus());
        return taskRepository.save(task);
    }


    @Override
    public Task getDeleteTask() {
        User user = userService.getCurrentUser();
        Task task = taskRepository.findByUser(user).orElse(null);
        taskRepository.delete(task);
        return task;
    }
}
