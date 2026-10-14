package com.videojuegos.videojuegos.service.impl;

import com.videojuegos.videojuegos.dto.UsuarioDTO;
import com.videojuegos.videojuegos.entity.UsuarioEntity;
import com.videojuegos.videojuegos.mapper.UsuarioMapper;
import com.videojuegos.videojuegos.repository.UsuarioRepository;
import com.videojuegos.videojuegos.service.UsuarioService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioMapper usuarioMapper, UsuarioRepository usuarioRepository) {
        this.usuarioMapper = usuarioMapper;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        UsuarioEntity entity = usuarioMapper.toUsuarioEntity(usuarioDTO);
        entity = usuarioRepository.save(entity);
        return usuarioMapper.toUsuarioDTO(entity);
    }
}