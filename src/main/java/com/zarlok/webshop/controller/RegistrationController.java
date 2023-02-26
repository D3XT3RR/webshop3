package com.zarlok.webshop.controller;

import com.zarlok.webshop.entity.Role;
import com.zarlok.webshop.entity.User;
import com.zarlok.webshop.exception.UserExistsException;
import com.zarlok.webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping("/")
public class RegistrationController {

    @Autowired
    UserService userService;

    private Logger logger = Logger.getLogger(getClass().getName());

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "default/registration/form";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user){
        Role role = new Role();
        role.setAuthority("ROLE_USER");
        role.setUser(user);
        user.setRole(role);
        user.setEnabled(true);

        logger.info("=== User Registration ===\n" + user.toString());

        try {
            userService.registerNewUser(user);
        } catch (UserExistsException e) {
            return "redirect:/register?error";
        }

        return "redirect:/login";
    }
}
