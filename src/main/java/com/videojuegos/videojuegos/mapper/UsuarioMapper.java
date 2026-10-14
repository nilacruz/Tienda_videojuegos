package com.videojuegos.videojuegos.mapper;

import com.videojuegos.videojuegos.dto.UsuarioDTO;
import com.videojuegos.videojuegos.entity.UsuarioEntity;

public interface UsuarioMapper {
    UsuarioEntity toUsuarioEntity(UsuarioDTO dto);
    UsuarioDTO toUsuarioDTO(UsuarioEntity entity);
}