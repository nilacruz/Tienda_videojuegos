package com.videojuegos.videojuegos.service.impl;
import com.videojuegos.videojuegos.dto.CategoriaDTO;
import com.videojuegos.videojuegos.entity.CategoriaEntity;
import com.videojuegos.videojuegos.mapper.CategoriaMapper;
import com.videojuegos.videojuegos.repository.CategoriaRepository;
import com.videojuegos.videojuegos.service.CategoriaService;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaMapper mapper;
    private final CategoriaRepository repository;
    public CategoriaServiceImpl(CategoriaMapper mapper, CategoriaRepository repository) {
        this.mapper = mapper; this.repository = repository;
    }
    @Override
    public CategoriaDTO save(CategoriaDTO dto) {
        CategoriaEntity entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }
}