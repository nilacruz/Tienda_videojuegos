package com.videojuegos.videojuegos.controller;
import com.videojuegos.videojuegos.dto.CategoriaDTO;
import com.videojuegos.videojuegos.service.CategoriaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriaService service;
    public CategoriaController(CategoriaService service) { this.service = service; }
    @PostMapping
    public CategoriaDTO save(@RequestBody CategoriaDTO dto) { return service.save(dto); }
}