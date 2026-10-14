package com.videojuegos.videojuegos.service.impl;

import com.videojuegos.videojuegos.dto.DesarrolladorDTO;
import com.videojuegos.videojuegos.entity.DesarrolladorEntity;
import com.videojuegos.videojuegos.mapper.DesarrolladorMapper;
import com.videojuegos.videojuegos.repository.DesarrolladorRepository;
import com.videojuegos.videojuegos.service.DesarrolladorService;
import org.springframework.stereotype.Service;

@Service
public class DesarrolladorServiceImpl implements DesarrolladorService {
    private final DesarrolladorMapper mapper;
    private final DesarrolladorRepository repository;
    public DesarrolladorServiceImpl(DesarrolladorMapper mapper, DesarrolladorRepository repository) {
        this.mapper = mapper; this.repository = repository;
    }
    @Override
    public DesarrolladorDTO save(DesarrolladorDTO dto) {
        DesarrolladorEntity entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }
}
