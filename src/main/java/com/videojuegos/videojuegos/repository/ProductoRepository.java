package com.videojuegos.videojuegos.repository;

import com.videojuegos.videojuegos.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {
}