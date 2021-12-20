package com.example.ProjectDiplom.service.impl;

import com.example.ProjectDiplom.entity.ClientInfo;
import com.example.ProjectDiplom.entity.User;
import com.example.ProjectDiplom.model.ClientInfoModel;
import com.example.ProjectDiplom.model.ClientInfoUpdateModel;
import com.example.ProjectDiplom.repository.ClientRepository;
import com.example.ProjectDiplom.repository.UserRepository;
import com.example.ProjectDiplom.repository.UserRoleRepository;
import com.example.ProjectDiplom.service.ClientInfoService;
import com.example.ProjectDiplom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientInfoServiceImpl implements ClientInfoService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Override
    public ClientInfo createClient(ClientInfoModel clientInfoModel) {
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setName(clientInfoModel.getName());
        clientInfo.setSerName(clientInfoModel.getSerName());
        clientInfo.setBalance(0.0);
        clientInfo.setGender(clientInfoModel.isGender());
        clientInfo.setPhone(clientInfoModel.getPhone());
        clientInfo.setAddress(clientInfoModel.getAddress());
        clientInfo.setEmail(clientInfoModel.getEmail());
        clientInfo.setDateOfBirth(clientInfoModel.getDateOfBirth());
        clientInfo.setUser(userService.getCurrentUser());
        return clientRepository.save(clientInfo);

    }


    @Override
    public List<ClientInfo> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public ClientInfo getByClientId(Long id) {
        return clientRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("Клиент таким ID нету"));
    }


    @Override
    public ClientInfo getByClientName(String clientName) {
        return clientRepository.findByName(clientName).orElse(null);
    }



    @Override
    public ClientInfo deleteClient() {
        User user = userService.getCurrentUser();
        ClientInfo clientInfo = clientRepository.findByUser(user).orElseThrow(
                () -> new IllegalArgumentException("Такой информации о клиенте нет")
        );
        clientRepository.delete(clientInfo);
        return clientInfo;
    }

    @Override
    public ClientInfo getUpdateClient(ClientInfoUpdateModel clientInfoUpdateModel) {
        ClientInfo clientInfo = clientRepository.findById(clientInfoUpdateModel.getId())
                .orElseThrow(() -> new IllegalArgumentException("Клиент таким ID нету"));
        clientInfo.setId(clientInfoUpdateModel.getId());
        clientInfo.setName(clientInfoUpdateModel.getName());
        clientInfo.setSerName(clientInfoUpdateModel.getSerName());
        clientInfo.setEmail(clientInfoUpdateModel.getEmail());
        clientInfo.setAddress(clientInfoUpdateModel.getAddress());
        clientInfo.setPhone(clientInfoUpdateModel.getPhone());
        clientInfo.setBalance(clientInfoUpdateModel.getBalance());

        return clientRepository.save(clientInfo);
    }


}
