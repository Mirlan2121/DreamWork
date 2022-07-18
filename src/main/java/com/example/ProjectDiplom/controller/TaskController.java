package com.example.ProjectDiplom.controller;

import com.example.ProjectDiplom.entity.Task;
import com.example.ProjectDiplom.model.Task.TaskModel;
import com.example.ProjectDiplom.model.Task.TaskStatusModel;
import com.example.ProjectDiplom.model.Task.TaskWorkersModel;
import com.example.ProjectDiplom.service.TaskService;
import com.example.ProjectDiplom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @PostMapping("/createTask")
    public Task createTask(@RequestBody TaskModel taskModel){
        return taskService.create(taskModel);
    }

    @GetMapping("/getAllTasks")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @PostMapping("/updateStatus")
    public Task getUpdateStatus(@RequestBody TaskStatusModel taskStatusModel){
        return taskService.getUpdateStatus(taskStatusModel);
    }

    @PostMapping("/updateWorkers")
    public Task getUpdateWorkers(@RequestBody TaskWorkersModel taskWorkersModel){
        return taskService.getWorkersUpdate(taskWorkersModel);
    }

    @DeleteMapping("/deleteTask/{id}")
    public Task deleteTask(@PathVariable Long id){
        return taskService.deleteTask(id);
    }

    @PostMapping("/getByIdTask/{id}")
    public Task getByIdTask(@PathVariable Long id){
        return taskService.getByIdTask(id);
    }
}
