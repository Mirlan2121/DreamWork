package com.example.ProjectDiplom.service;

import com.example.ProjectDiplom.entity.ClientInfo;
import com.example.ProjectDiplom.model.Client.ClientInfoModel;
import com.example.ProjectDiplom.model.Client.ClientInfoUpdateModel;

import java.util.List;

public interface ClientInfoService {
    ClientInfo createClient(ClientInfoModel clientInfoModel);

    List<ClientInfo> getAll();

    ClientInfo getByClientId(Long id);

    ClientInfo getByClientName(String clientName);

    ClientInfo deleteClient();

    ClientInfo getUpdateClient(ClientInfoUpdateModel clientInfoUpdateModel);


}
