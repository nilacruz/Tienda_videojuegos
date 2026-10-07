package com.videojuegos.videojuegos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class alanController {
    @GetMapping("/alan")
    public String alan() {
        return "Endpoint de alan";
    }
}