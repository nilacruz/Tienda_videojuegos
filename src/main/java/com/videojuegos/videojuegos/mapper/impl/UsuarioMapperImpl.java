package com.videojuegos.videojuegos.mapper.impl;

import com.videojuegos.videojuegos.dto.UsuarioDTO;
import com.videojuegos.videojuegos.entity.UsuarioEntity;
import com.videojuegos.videojuegos.mapper.UsuarioMapper;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioEntity toUsuarioEntity(UsuarioDTO dto) {
        if (dto == null) return null;

        UsuarioEntity entity = new UsuarioEntity();
        entity.setIdUsuario(dto.getIdUsuario());
        entity.setNombre(dto.getNombre());
        entity.setCorreo(dto.getCorreo());
        entity.setTelefono(dto.getTelefono());
        entity.setPassword(dto.getPassword());
        return entity;
    }

    @Override
    public UsuarioDTO toUsuarioDTO(UsuarioEntity entity) {
        if (entity == null) return null;

        UsuarioDTO dto = new UsuarioDTO();
        dto.setIdUsuario(entity.getIdUsuario());
        dto.setNombre(entity.getNombre());
        dto.setCorreo(entity.getCorreo());
        dto.setTelefono(entity.getTelefono());
        dto.setPassword(entity.getPassword());
        return dto;
    }
}