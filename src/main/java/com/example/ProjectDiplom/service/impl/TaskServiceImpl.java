package com.example.ProjectDiplom.service.impl;

import com.example.ProjectDiplom.entity.*;
import com.example.ProjectDiplom.enam.TaskStatus;
import com.example.ProjectDiplom.model.TaskModel;
import com.example.ProjectDiplom.model.TaskStatusModel;
import com.example.ProjectDiplom.model.TaskWorkersModel;
import com.example.ProjectDiplom.repository.ClientRepository;
import com.example.ProjectDiplom.repository.CompanyRepository;
import com.example.ProjectDiplom.repository.TaskRepository;
import com.example.ProjectDiplom.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private ClientInfoService clientInfoService;

    @Autowired
    private TypeCatalogService typeCatalogService;

    @Autowired
    private WorkersInfoService workersInfoService;

    @Override
    public Task create(TaskModel taskModel) {
        User user =  userService.getCurrentUser();

        Task task = new Task();

        task.setName(taskModel.getName());

        task.setDescription(taskModel.getDescription());

        task.setCompany(companyService.getByCompanyId(taskModel.getCompany()));

        task.setClientInfo(clientInfoService.getByClientId(taskModel.getClient()));

        task.setTaskStatus(TaskStatus.NEW_OPEN);

        task.setTypeCatalog(typeCatalogService.getByTypeId(taskModel.getTypeCatalog()));


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
    public Task getByIdTask(Long id) {
        return taskRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Заявка c таким ID нету"));
    }


    @Override
    public Task deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        taskRepository.deleteById(id);
        return task;
    }

    @Override
    public Task getWorkersUpdate(TaskWorkersModel taskWorkersModel) {
        Task task = taskRepository.findById(taskWorkersModel.getId()).orElse(null);
        WorkersInfo workersInfo = workersInfoService.getByWorkersId(taskWorkersModel.getWorkers());
        task.setWorkersInfo(workersInfo);
        return taskRepository.save(task);
    }
}
