package application.controller;

import application.model.User;
import application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users",userService.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") long id,  Model model){
        model.addAttribute("user_id", userService.getUserById(id));
        return "user";
    }

    @PostMapping(value = "/save_user")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "save";
    }


}
