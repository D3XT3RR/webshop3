package com.zarlok.webshop.controller;

import com.zarlok.webshop.entity.Role;
import com.zarlok.webshop.entity.User;
import com.zarlok.webshop.service.RoleService;
import com.zarlok.webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/manage/user")
public class UserManagementController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/list")
    public String listUsers(Model model){
        List<User> userList = userService.getUsers();
        model.addAttribute(userList);
        return "management/users/list";
    }

    @GetMapping("/add")
    public String addUser(Model model){
        User user = new User();
        model.addAttribute(user);
        return "management/users/add-form";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user){
        Role tempRole = user.getRole();
        tempRole.setUser(user);
        user.setRole(tempRole);
        userService.registerNewUser(user);
        roleService.saveRole(tempRole);
        return "redirect:/manage/user/list";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/manage/user/list";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") String username){
        userService.deleteUser(username);

        return "redirect:/manage/user/list";
    }



}
