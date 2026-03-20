package com.example.ThanhHoai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/test-connection.html")
    public String testConnection() {
        return "test-connection";
    }
}
