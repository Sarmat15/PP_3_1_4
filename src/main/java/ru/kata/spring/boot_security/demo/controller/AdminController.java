package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;


import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminController(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String getAllUser(Model model, Principal principal) {
        model.addAttribute("admin", userService.findByEmail(principal.getName()));
        model.addAttribute("users", userService.getList());
        model.addAttribute("roles", roleService.getList());
        model.addAttribute("user", new User());
        return "admin";
    }

    @GetMapping("/{id}")
    public String getUser(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("user", userService.getUserAndRole(id));
        return "user";
    }

    @GetMapping("/newUserAdmin")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getList());
        return "newAdmin";
    }

    @PostMapping("/newUserAdmin")
    public String saveNewUser(
            @ModelAttribute("newUser") User user
            ) {
        userService.add(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/editUser/{id}")
    public String editUser(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("user", userService.getUserAndRole(id));
        model.addAttribute("roles",roleService.getList());
        return "editAdmin";
    }

    @PostMapping("/{id}")
    public String userSaveEdit(@PathVariable("id") Integer id, @ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/admin";
    }
}