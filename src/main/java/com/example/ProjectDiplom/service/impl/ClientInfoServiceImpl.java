package com.example.ProjectDiplom.service.impl;

import com.example.ProjectDiplom.entity.ClientInfo;
import com.example.ProjectDiplom.entity.User;
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
    public ClientInfo createClient(ClientInfo clientInfo) {
        clientInfo.setBalance(0.0);
        clientInfo.setUser(userService.getCurrentUser());
        return clientInfo;

    }


    @Override
    public List<ClientInfo> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public ClientInfo getByClientId(Long id) {
        return clientRepository.findById(id).orElse(null);
    }


    @Override
    public ClientInfo getByClientName(String clientName) {
        return clientRepository.findByName(clientName).orElse(null);
    }

    @Override
    public ClientInfo deleteClient() {
        User user = userService.getCurrentUser();
        ClientInfo clientInfo = clientRepository.findByUser(user).orElseThrow(
                () -> new IllegalArgumentException("Такой инфы нет")
        );
        clientRepository.delete(clientInfo);
        return clientInfo;
    }


}
