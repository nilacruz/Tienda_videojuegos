package com.videojuegos.videojuegos.mapper;

import com.videojuegos.videojuegos.dto.MetodoPagoDTO;
import com.videojuegos.videojuegos.entity.MetodoPagoEntity;

public interface MetodoPagoMapper {
    MetodoPagoEntity toEntity(MetodoPagoDTO dto);
    MetodoPagoDTO toDTO(MetodoPagoEntity entity);
}