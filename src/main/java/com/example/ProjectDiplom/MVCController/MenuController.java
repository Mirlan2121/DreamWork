package com.example.ProjectDiplom.MVCController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class MenuController { // Санек
    @GetMapping("/")
    public String menuStart(Model model){
        model.addAttribute("menu", "Старт страницы");
        return "menu";
    }
}
