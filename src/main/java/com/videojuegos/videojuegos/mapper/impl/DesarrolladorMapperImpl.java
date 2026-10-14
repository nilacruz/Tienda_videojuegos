package com.videojuegos.videojuegos.mapper.impl;
import com.videojuegos.videojuegos.dto.DesarrolladorDTO;
import com.videojuegos.videojuegos.entity.DesarrolladorEntity;
import com.videojuegos.videojuegos.mapper.DesarrolladorMapper;
import org.springframework.stereotype.Component;

@Component
public class DesarrolladorMapperImpl implements DesarrolladorMapper {
    @Override
    public DesarrolladorEntity toEntity(DesarrolladorDTO dto) {
        if (dto == null) return null;
        DesarrolladorEntity entity = new DesarrolladorEntity();
        entity.setIdDesarrollador(dto.getIdDesarrollador());
        entity.setNombre(dto.getNombre());
        entity.setSitioWeb(dto.getSitioWeb());
        return entity;
    }

    @Override
    public DesarrolladorDTO toDTO(DesarrolladorEntity entity) {
        if (entity == null) return null;
        DesarrolladorDTO dto = new DesarrolladorDTO();
        dto.setIdDesarrollador(entity.getIdDesarrollador());
        dto.setNombre(entity.getNombre());
        dto.setSitioWeb(entity.getSitioWeb());
        return dto;
    }
}
