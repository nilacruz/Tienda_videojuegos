package com.videojuegos.videojuegos.mapper;

import com.videojuegos.videojuegos.dto.ProductoDTO;
import com.videojuegos.videojuegos.entity.ProductoEntity;

public interface ProductoMapper {
    ProductoEntity toProductoEntity(ProductoDTO dto);
    ProductoDTO toProductoDTO(ProductoEntity entity);
}
