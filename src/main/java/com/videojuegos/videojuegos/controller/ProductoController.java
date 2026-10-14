package com.videojuegos.videojuegos.controller;

import com.videojuegos.videojuegos.dto.ProductoDTO;
import com.videojuegos.videojuegos.service.ProductoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ProductoDTO save(@RequestBody ProductoDTO productoDTO) {
        return productoService.save(productoDTO);
    }
}
