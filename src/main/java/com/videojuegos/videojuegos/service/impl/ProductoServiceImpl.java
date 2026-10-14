package com.videojuegos.videojuegos.service.impl;

import com.videojuegos.videojuegos.dto.ProductoDTO;
import com.videojuegos.videojuegos.entity.ProductoEntity;
import com.videojuegos.videojuegos.mapper.ProductoMapper;
import com.videojuegos.videojuegos.repository.ProductoRepository;
import com.videojuegos.videojuegos.service.ProductoService;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoMapper productoMapper;
    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoMapper productoMapper, ProductoRepository productoRepository) {
        this.productoMapper = productoMapper;
        this.productoRepository = productoRepository;
    }

    @Override
    public ProductoDTO save(ProductoDTO productoDTO) {
        ProductoEntity entity = productoMapper.toProductoEntity(productoDTO);
        entity = productoRepository.save(entity);
        return productoMapper.toProductoDTO(entity);
    }
}