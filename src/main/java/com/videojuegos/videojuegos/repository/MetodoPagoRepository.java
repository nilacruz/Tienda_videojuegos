package com.videojuegos.videojuegos.repository;

import com.videojuegos.videojuegos.entity.MetodoPagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoPagoRepository extends JpaRepository<MetodoPagoEntity, Long> {
}