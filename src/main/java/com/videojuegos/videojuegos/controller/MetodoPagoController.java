package com.videojuegos.videojuegos.controller;

import com.videojuegos.videojuegos.dto.MetodoPagoDTO;
import com.videojuegos.videojuegos.service.MetodoPagoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/metodos-pago")
public class MetodoPagoController {

    private final MetodoPagoService service;

    public MetodoPagoController(MetodoPagoService service) {
        this.service = service;
    }

    @PostMapping
    public MetodoPagoDTO save(@RequestBody MetodoPagoDTO dto) {
        return service.save(dto);
    }
}