package com.videojuegos.videojuegos.mapper.impl;

import com.videojuegos.videojuegos.dto.ProductoDTO;
import com.videojuegos.videojuegos.entity.ProductoEntity;
import com.videojuegos.videojuegos.mapper.ProductoMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapperImpl implements ProductoMapper {

    @Override
    public ProductoEntity toProductoEntity(ProductoDTO dto) {
        if (dto == null) return null;

        ProductoEntity entity = new ProductoEntity();
        entity.setIdProducto(dto.getIdProducto());
        entity.setIdDesarrollador(dto.getIdDesarrollador());
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        entity.setPrecio(dto.getPrecio());
        entity.setImg(dto.getImg());
        entity.setEspecificaciones(dto.getEspecificaciones());
        entity.setAnioEmision(dto.getAnioEmision());
        return entity;
    }

    @Override
    public ProductoDTO toProductoDTO(ProductoEntity entity) {
        if (entity == null) return null;

        ProductoDTO dto = new ProductoDTO();
        dto.setIdProducto(entity.getIdProducto());
        dto.setIdDesarrollador(entity.getIdDesarrollador());
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());
        dto.setPrecio(entity.getPrecio());
        dto.setImg(entity.getImg());
        dto.setEspecificaciones(entity.getEspecificaciones());
        dto.setAnioEmision(entity.getAnioEmision());
        return dto;
    }
}