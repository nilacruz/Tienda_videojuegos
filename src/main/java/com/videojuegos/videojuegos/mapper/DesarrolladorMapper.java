package com.videojuegos.videojuegos.mapper;
import com.videojuegos.videojuegos.dto.DesarrolladorDTO;
import com.videojuegos.videojuegos.entity.DesarrolladorEntity;

public interface DesarrolladorMapper {
    DesarrolladorEntity toEntity(DesarrolladorDTO dto);
    DesarrolladorDTO toDTO(DesarrolladorEntity entity);
}