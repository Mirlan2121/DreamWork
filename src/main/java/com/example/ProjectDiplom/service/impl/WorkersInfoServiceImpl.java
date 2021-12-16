package com.example.ProjectDiplom.service.impl;

import com.example.ProjectDiplom.entity.User;
import com.example.ProjectDiplom.entity.UserRole;
import com.example.ProjectDiplom.entity.WorkersInfo;
import com.example.ProjectDiplom.model.CreateWorkersInfoModel;
import com.example.ProjectDiplom.model.UserAuthModel;
import com.example.ProjectDiplom.repository.UserRepository;
import com.example.ProjectDiplom.repository.UserRoleRepository;
import com.example.ProjectDiplom.repository.WorkersRepository;
import com.example.ProjectDiplom.service.UserService;
import com.example.ProjectDiplom.service.WorkersInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class WorkersInfoServiceImpl implements WorkersInfoService {

    @Autowired
    private WorkersRepository workersRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserService userService;



    @Override
    public WorkersInfo createWorker(WorkersInfo workersInfo) {
        workersInfo.setUser(userService.getCurrentUser());
        return workersInfo;
    }

    @Override
    public List <WorkersInfo> getAll() {
        return workersRepository.findAll();
    }

    @Override
    public WorkersInfo getByWorkersId(Long id) {
        return workersRepository.findById(id).orElse(null);
    }


    @Override
    public WorkersInfo getByWorkersName(String name) {
        return workersRepository.findByName(name).orElse(null);
    }

    @Override
    public WorkersInfo getDeleteWorkers() {
        User user = userService.getCurrentUser();
        WorkersInfo workersInfo = workersRepository.findByUser(user).orElseThrow(
                () -> new IllegalArgumentException("Такой инфы нет")
        );
        workersRepository.delete(workersInfo);
        return workersInfo;
    }



}
