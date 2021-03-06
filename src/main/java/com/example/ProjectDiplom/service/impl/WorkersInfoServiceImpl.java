package com.example.ProjectDiplom.service.impl;

import com.example.ProjectDiplom.entity.User;
import com.example.ProjectDiplom.entity.WorkersInfo;
import com.example.ProjectDiplom.model.Workers.WorkersInfoModel;
import com.example.ProjectDiplom.model.Workers.WorkersInfoUpdateModel;
import com.example.ProjectDiplom.repository.UserRepository;
import com.example.ProjectDiplom.repository.UserRoleRepository;
import com.example.ProjectDiplom.repository.WorkersRepository;
import com.example.ProjectDiplom.service.TypeCatalogService;
import com.example.ProjectDiplom.service.UserService;
import com.example.ProjectDiplom.service.WorkerCompanyService;
import com.example.ProjectDiplom.service.WorkersInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

    @Autowired
    private TypeCatalogService catalogService;

    @Autowired
    private WorkerCompanyService workerCompanyService;


    @Override
    public WorkersInfo createWorker(WorkersInfoModel workersInfoModel) {
        WorkersInfo workersInfo = new WorkersInfo();
        workersInfo.setName(workersInfoModel.getName());
        workersInfo.setSerName(workersInfoModel.getSerName());
        workersInfo.setAddress(workersInfoModel.getAddress());
        workersInfo.setPhone(workersInfoModel.getPhone());
        workersInfo.setEmail(workersInfoModel.getEmail());
        workersInfo.setGender(workersInfoModel.isGender());
        workersInfo.setDateOfBirth(workersInfoModel.getDateOfBirth());
        workersInfo.setTypeCatalog(catalogService.getByTypeId(workersInfoModel.getTypeCatalog()));
        workersInfo.setUser(userService.getCurrentUser());
        workersInfo = workersRepository.save(workersInfo);
        return workersInfo;
    }

    @Override
    public List<WorkersInfo> getAll() {
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
                () -> new IllegalArgumentException("?????????? ???????????????????? ?? ???????????????????? ??????")
        );
        workersRepository.delete(workersInfo);
        return workersInfo;
    }

    @Override
    public WorkersInfo getUpdateWorkers(WorkersInfoUpdateModel workersInfoUpdateModel) {
        WorkersInfo workersInfo = workersRepository.findById(workersInfoUpdateModel.getId()).orElseThrow(()
                -> new IllegalArgumentException("?????????? ID ???????????????????? ?????? "));
        workersInfo.setId(workersInfo.getId());
        workersInfo.setName(workersInfoUpdateModel.getName());
        workersInfo.setSerName(workersInfoUpdateModel.getSerName());
        workersInfo.setEmail(workersInfoUpdateModel.getEmail());
        workersInfo.setPhone(workersInfoUpdateModel.getPhone());
        workersInfo.setAddress(workersInfoUpdateModel.getAddress());
        return workersRepository.save(workersInfo);
    }


}
