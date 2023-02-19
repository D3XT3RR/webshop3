package com.zarlok.webshop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage")
public class ManagementController {

    @GetMapping("/")
    public String managementLinks(){
        return "/management/index";
    }
}
