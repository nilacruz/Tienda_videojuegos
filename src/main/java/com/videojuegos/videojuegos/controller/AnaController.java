package com.videojuegos.videojuegos.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class AnaController{
    @GetMapping("/ana")
    public String ana(){
        return "Endpoint de ana";
    }
}