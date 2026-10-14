package com.videojuegos.videojuegos.controller;
import com.videojuegos.videojuegos.dto.DesarrolladorDTO;
import com.videojuegos.videojuegos.service.DesarrolladorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/desarrolladores")
public class DesarrolladorController {
    private final DesarrolladorService service;
    public DesarrolladorController(DesarrolladorService service) { this.service = service; }
    @PostMapping
    public DesarrolladorDTO save(@RequestBody DesarrolladorDTO dto) { return service.save(dto); }
}