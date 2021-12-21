package com.example.ProjectDiplom.MVCController;

import com.example.ProjectDiplom.entity.ClientInfo;
import com.example.ProjectDiplom.service.ClientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("/patClientInfo")
public class PatUserInfoController {
    @Autowired
    private ClientInfoService clientInfoService;

    @GetMapping("/patClientInfo")
    public String getAllPatUsersInfo(Model model){
        model.addAttribute("PatClientInfo", new ClientInfo());
        return "patClientInfo";
    }
    @PostMapping("/patClientInfo")
    public String setInfo(@ModelAttribute("PatClientInfo") ClientInfo clientInfo, Model model){
        System.out.println(clientInfo);

        return "/";
    }
}
