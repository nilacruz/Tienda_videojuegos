package com.videojuegos.videojuegos.controller;

import com.videojuegos.videojuegos.dto.OrdenDTO;
import com.videojuegos.videojuegos.service.OrdenService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {

    private final OrdenService service;

    public OrdenController(OrdenService service) {
        this.service = service;
    }

    @PostMapping
    public OrdenDTO save(@RequestBody OrdenDTO dto) {
        return service.save(dto);
    }
}