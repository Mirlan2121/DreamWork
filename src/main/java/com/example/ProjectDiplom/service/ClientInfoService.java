package com.example.ProjectDiplom.service;

import com.example.ProjectDiplom.entity.ClientInfo;

import java.util.List;

public interface ClientInfoService {
    ClientInfo createClient(ClientInfo clientInfo);

    List<ClientInfo> getAll();

    ClientInfo getByClientId(Long id);

    ClientInfo getByClientName(String clientName);

    ClientInfo deleteClient();



}
