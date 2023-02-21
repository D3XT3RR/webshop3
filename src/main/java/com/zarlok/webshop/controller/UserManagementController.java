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
import java.util.logging.Logger;

@Controller
@RequestMapping("/manage/user")
public class UserManagementController {

    @Autowired
    private UserService userService;


    private Logger logger = Logger.getLogger(getClass().getName());

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

    @GetMapping("/update")
    public String updateUser(@RequestParam("username") String username, Model model){
        User user = userService.getUser(username);
        //Role role = roleService.getRole(username);
        logger.info("\n === GetMapping updateUser === \n"+user.toString());
        //logger.info("\n === GetMapping updateUser === \n"+role.toString());
        model.addAttribute("user", user);
        //model.addAttribute("role", role);
        return "management/users/edit-form";
    }

//    @PostMapping("/register")
//    public String editUser(@ModelAttribute("user") User user){
//        Role tempRole = user.getRole();
//        tempRole.setUser(user);
//        user.setRole();
//    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        Role tempRole = user.getRole();
        tempRole.setUser(user);
        user.setRole(tempRole);
        userService.registerNewUser(user);
        roleService.saveRole(tempRole);
        return "redirect:/manage/user/list";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user){
        logger.info("\n === PostMapping updateUser ===\n" +user.toString());
        //logger.info(role.toString());
        //role.setAuthority(user.getRole().getAuthority());
        //logger.info("Role.user.username: " + role.getUser().getUsername() + "; Role.authority:" + role.getAuthority());
        //user.setRole(role);
        Role tempRole = user.getRole();
        tempRole.setUser(user);
        user.setRole(tempRole);
        userService.updateUser(user);
        //roleService.updateRole(tempRole);

        return "redirect:/manage/user/list";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") String username){
        userService.deleteUser(username);

        return "redirect:/manage/user/list";
    }



}
