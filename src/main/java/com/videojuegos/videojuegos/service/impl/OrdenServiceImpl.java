package com.videojuegos.videojuegos.service.impl;

import com.videojuegos.videojuegos.dto.OrdenDTO;
import com.videojuegos.videojuegos.entity.OrdenEntity;
import com.videojuegos.videojuegos.mapper.OrdenMapper;
import com.videojuegos.videojuegos.repository.OrdenRepository;
import com.videojuegos.videojuegos.service.OrdenService;
import org.springframework.stereotype.Service;

@Service
public class OrdenServiceImpl implements OrdenService {

    private final OrdenMapper mapper;
    private final OrdenRepository repository;

    public OrdenServiceImpl(OrdenMapper mapper, OrdenRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public OrdenDTO save(OrdenDTO dto) {
        OrdenEntity entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }
}