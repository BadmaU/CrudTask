package application.controller;

import application.model.User;
import application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users",userService.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") long id,  Model model){
        model.addAttribute("user_id", userService.getUserById(id));
        return "users";
    }

    @GetMapping(value = "/add")
    public String addUser(Model model){
        model.addAttribute("user", new User());
        return "save";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/{id}/update")
    public String updateUserById(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") long id){
        userService.updateUserById(id, user);
        return "redirect:/users";
    }

    @DeleteMapping(value = "/{id}")
    public String removeUserById(@PathVariable("id") long id){
        userService.removeUserById(id);
        return "redirect:/users";
    }
}
