package com.videojuegos.videojuegos.service.impl;

import com.videojuegos.videojuegos.dto.MetodoPagoDTO;
import com.videojuegos.videojuegos.entity.MetodoPagoEntity;
import com.videojuegos.videojuegos.mapper.MetodoPagoMapper;
import com.videojuegos.videojuegos.repository.MetodoPagoRepository;
import com.videojuegos.videojuegos.service.MetodoPagoService;
import org.springframework.stereotype.Service;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService {

    private final MetodoPagoMapper mapper;
    private final MetodoPagoRepository repository;

    public MetodoPagoServiceImpl(MetodoPagoMapper mapper, MetodoPagoRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public MetodoPagoDTO save(MetodoPagoDTO dto) {
        MetodoPagoEntity entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }
}