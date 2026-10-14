package com.videojuegos.videojuegos.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Categoria")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_categoria")
    private Long idCategoria;

    @Column(name = "Nombre", nullable = false, length = 100)
    private String nombre;

    // Con esta línea hacemos la relación bidireccional
    // "La configuración principal de esta relación está en la variable 'categorias' de ProductoEntity"
    @ManyToMany(mappedBy = "categorias")
    private Set<ProductoEntity> productos;


    public Long getIdCategoria() { return idCategoria; }
    public void setIdCategoria(Long idCategoria) { this.idCategoria = idCategoria; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Set<ProductoEntity> getProductos() { return productos; }
    public void setProductos(Set<ProductoEntity> productos) { this.productos = productos; }
}