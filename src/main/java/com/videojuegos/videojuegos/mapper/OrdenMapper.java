package com.videojuegos.videojuegos.mapper;

import com.videojuegos.videojuegos.dto.OrdenDTO;
import com.videojuegos.videojuegos.entity.OrdenEntity;

public interface OrdenMapper {
    OrdenEntity toEntity(OrdenDTO dto);
    OrdenDTO toDTO(OrdenEntity entity);
}
