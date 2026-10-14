package com.videojuegos.videojuegos.repository;
import com.videojuegos.videojuegos.entity.DesarrolladorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesarrolladorRepository extends JpaRepository<DesarrolladorEntity, Long> {}