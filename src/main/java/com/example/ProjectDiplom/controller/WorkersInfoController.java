package com.example.ProjectDiplom.controller;


import com.example.ProjectDiplom.entity.WorkersInfo;
import com.example.ProjectDiplom.repository.WorkersRepository;
import com.example.ProjectDiplom.service.UserService;
import com.example.ProjectDiplom.service.WorkersInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkersInfoController {

    @Autowired
    private WorkersInfoService workersInfoService;

    @Autowired
    private WorkersRepository workersRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/createWorkers")
    public WorkersInfo createWorkers(@RequestBody WorkersInfo workersInfo) throws IllegalArgumentException{
      if (workersInfoService.getByWorkersName(workersInfo.getName()) != null){
          throw new IllegalArgumentException("Такой работник есть");
      }else
        return workersInfoService.createWorker(workersInfo);
    }

    @GetMapping("/getAll")
    public List<WorkersInfo> getAll(){
        return workersInfoService.getAll();
    }

    @PostMapping("/getByWorkersId/{id}")
    public WorkersInfo getByWorkersId(@PathVariable Long id){
        return workersInfoService.getByWorkersId(id);
    }

    @DeleteMapping("/deleteWorkers")
    public WorkersInfo getDeleteWorkers(){
        return workersInfoService.getDeleteWorkers();
    }
}
