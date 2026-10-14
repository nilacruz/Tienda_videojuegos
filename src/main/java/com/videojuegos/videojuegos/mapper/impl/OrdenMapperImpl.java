package com.videojuegos.videojuegos.mapper.impl;

import com.videojuegos.videojuegos.dto.OrdenDTO;
import com.videojuegos.videojuegos.entity.OrdenEntity;
import com.videojuegos.videojuegos.entity.UsuarioEntity; // Importante
import com.videojuegos.videojuegos.mapper.OrdenMapper;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("DuplicatedCode")
public class OrdenMapperImpl implements OrdenMapper {

    @Override
    public OrdenEntity toEntity(OrdenDTO dto) {
        if (dto == null) return null;
        OrdenEntity entity = new OrdenEntity();
        entity.setIdOrden(dto.getIdOrden());

        // Asignar la relación con el Usuario
        if (dto.getIdUsuario() != null) {
            UsuarioEntity user = new UsuarioEntity();
            user.setIdUsuario(dto.getIdUsuario());
            entity.setUsuario(user);
        }

        entity.setFecha(dto.getFecha());
        entity.setTotal(dto.getTotal());
        return entity;
    }

    @Override
    public OrdenDTO toDTO(OrdenEntity entity) {
        if (entity == null) return null;
        OrdenDTO dto = new OrdenDTO();
        dto.setIdOrden(entity.getIdOrden());

        // Extraer el ID del Usuario
        if (entity.getUsuario() != null) {
            dto.setIdUsuario(entity.getUsuario().getIdUsuario());
        }

        dto.setFecha(entity.getFecha());
        dto.setTotal(entity.getTotal());
        return dto;
    }
}