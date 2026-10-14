package com.videojuegos.videojuegos.mapper.impl;

import com.videojuegos.videojuegos.dto.MetodoPagoDTO;
import com.videojuegos.videojuegos.entity.MetodoPagoEntity;
import com.videojuegos.videojuegos.mapper.MetodoPagoMapper;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("DuplicatedCode")
public class MetodoPagoMapperImpl implements MetodoPagoMapper {

    @Override
    public MetodoPagoEntity toEntity(MetodoPagoDTO dto) {
        if (dto == null) return null;
        MetodoPagoEntity entity = new MetodoPagoEntity();
        entity.setIdMPago(dto.getIdMPago());
        entity.setNombre(dto.getNombre());
        entity.setActivo(dto.getActivo());
        return entity;
    }

    @Override
    public MetodoPagoDTO toDTO(MetodoPagoEntity entity) {
        if (entity == null) return null;
        MetodoPagoDTO dto = new MetodoPagoDTO();
        dto.setIdMPago(entity.getIdMPago());
        dto.setNombre(entity.getNombre());
        dto.setActivo(entity.getActivo());
        return dto;
    }
}