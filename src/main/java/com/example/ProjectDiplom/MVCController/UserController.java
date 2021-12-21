package com.example.ProjectDiplom.MVCController;

import com.example.ProjectDiplom.entity.ClientInfo;
import com.example.ProjectDiplom.entity.User;
import com.example.ProjectDiplom.model.UserAuthModel;
import com.example.ProjectDiplom.service.ClientInfoService;
import com.example.ProjectDiplom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ClientInfoService clientInfoService;
    @GetMapping("/userall")
    public String getAllUsers(Model model){
        Iterable<User> allUser = userService.getAllUsers();
        model.addAttribute("users", allUser);
        model.addAttribute("log", "Не известный пользователь");
        return "users";
    }

    @GetMapping("/newuser")
    public String menuUsers(Model model){
        return "newuser";
    }
    @GetMapping("/loguser")
    public String logUsers(Model model){
        return "loguser";
    }

    @PostMapping("/loguser")// санек
    public String logUser (@RequestParam String username, @RequestParam String password, Model model){
        if((password.isEmpty() || password == null) || (username.isEmpty() || username == null)) {// санек
            model.addAttribute("texterror", "Нельзя оставлять поля пустыми");
            return "loguser";// санек
        }
        UserAuthModel user = UserAuthModel.builder().username(username).password(password).build();// мирлан
        model.addAttribute("log", user.getUsername());
        String write =
        userService.getAuthorizationToken(UserAuthModel.builder().username(username).password(password).build());
        System.out.println(write);
        return "redirect:/userall";
    }

    @PostMapping("/newuser")
    public String newUser(@RequestParam String username, @RequestParam String password, Model model){
        User user = User.builder().username(username).password(password).userInfo("Клиент").active(1L).build();
        if((password.isEmpty() || password == null) || (username.isEmpty() || username == null)) {
            model.addAttribute("texterror", "Нельзя оставлять поля пустыми");
            return "newuser";
        }
        userService.create(user);
        model.addAttribute("PatClientInfo", new ClientInfo());
        return "patClientInfo";
    }
}
