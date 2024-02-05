package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("")
    public String getAllUsers(Model model) {
        model.addAttribute("users", service.getAllUsers());
        return "users";
    }
    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "newuser";
    }
    @PostMapping("/new")
    public String create(@ModelAttribute ("user") User user){
        service.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/update")
    public String updateForm(Model model, @RequestParam ("id") long id){
        model.addAttribute("user", service.getUser(id));
        return "userupdate";
    }
    @PostMapping("/update")
    public String submitUpdate(@ModelAttribute("user") User user, @RequestParam("id") long id){
        user.setId(id);
        service.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteForm(Model model, @RequestParam("id") long id){
        model.addAttribute("user", service.getUser(id));
        return "deleteUser";
    }
    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") long id){
        service.deleteUser(id);
        return "redirect:/users";
    }
}
