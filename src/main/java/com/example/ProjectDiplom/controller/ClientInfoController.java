package com.example.ProjectDiplom.controller;

import com.example.ProjectDiplom.entity.ClientInfo;
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
    public ClientInfo createCustomer(@RequestBody ClientInfo clientInfo) throws IllegalArgumentException  {
        if (clientInfoService.getByClientName(clientInfo.getName()) != null){
            throw new IllegalArgumentException("Такой клиент уже есть");
        }else

        return clientInfoService.createClient(clientInfo);
    }

    @GetMapping("/getAll")
    public List<ClientInfo> getAll() {
        return clientInfoService.getAll();
    }

    @PostMapping("/clientName/{clientName}")
    public ClientInfo getByCustomerName(@PathVariable String customerName) {
        return clientInfoService.getByClientName(customerName);
    }

    @PostMapping("/getById/{id}")
    public ClientInfo getById(@PathVariable Long id) {
        return clientInfoService.getByClientId(id);
    }

    @DeleteMapping("/delete")
    public ClientInfo deleteClient(){
        return clientInfoService.deleteClient();
    }

}

