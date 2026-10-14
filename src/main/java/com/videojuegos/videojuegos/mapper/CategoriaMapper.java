package com.videojuegos.videojuegos.mapper;
import com.videojuegos.videojuegos.dto.CategoriaDTO;
import com.videojuegos.videojuegos.entity.CategoriaEntity;

public interface CategoriaMapper {
    CategoriaEntity toEntity(CategoriaDTO dto);
    CategoriaDTO toDTO(CategoriaEntity entity);
}