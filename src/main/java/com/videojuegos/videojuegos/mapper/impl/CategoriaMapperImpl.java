package com.videojuegos.videojuegos.mapper.impl;
import com.videojuegos.videojuegos.dto.CategoriaDTO;
import com.videojuegos.videojuegos.entity.CategoriaEntity;
import com.videojuegos.videojuegos.mapper.CategoriaMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapperImpl implements CategoriaMapper {
    @Override
    public CategoriaEntity toEntity(CategoriaDTO dto) {
        if (dto == null) return null;
        CategoriaEntity entity = new CategoriaEntity();
        entity.setIdCategoria(dto.getIdCategoria());
        entity.setNombre(dto.getNombre());
        return entity;
    }

    @Override
    public CategoriaDTO toDTO(CategoriaEntity entity) {
        if (entity == null) return null;
        CategoriaDTO dto = new CategoriaDTO();
        dto.setIdCategoria(entity.getIdCategoria());
        dto.setNombre(entity.getNombre());
        return dto;
    }
}