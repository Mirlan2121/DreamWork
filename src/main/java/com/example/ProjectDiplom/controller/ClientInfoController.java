package com.example.ProjectDiplom.controller;

import com.example.ProjectDiplom.entity.ClientInfo;
import com.example.ProjectDiplom.model.Client.ClientInfoModel;
import com.example.ProjectDiplom.model.Client.ClientInfoUpdateModel;
import com.example.ProjectDiplom.repository.ClientRepository;
import com.example.ProjectDiplom.service.ClientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientInfo")
public class ClientInfoController {
    @Autowired
    private ClientInfoService clientInfoService;
    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("/create")
    public ClientInfo createCustomer(@RequestBody ClientInfoModel clientInfoModel) throws IllegalArgumentException  {
        if (clientInfoService.getByClientName(clientInfoModel.getName()) != null){
            throw new IllegalArgumentException("Такой клиент уже есть");
        }else

        return clientInfoService.createClient(clientInfoModel);
    }

    @GetMapping("/getAll")
    public List<ClientInfo> getAll() {
        return clientInfoService.getAll();
    }

    @GetMapping("/clientName/{customerName}")
    public ClientInfo getByCustomerName(@PathVariable String customerName) {
        return clientInfoService.getByClientName(customerName);
    }

    @GetMapping("/getById/{id}")
    public ClientInfo getById(@PathVariable Long id) {
        return clientInfoService.getByClientId(id);
    }

    @DeleteMapping("/deleteClient")
    public ClientInfo deleteClient(){
        return clientInfoService.deleteClient();
    }

    @PostMapping("/updateClient")
    public ClientInfo updateClient(@RequestBody ClientInfoUpdateModel clientInfoUpdateModel){
        return clientInfoService.getUpdateClient(clientInfoUpdateModel);
    }
}

