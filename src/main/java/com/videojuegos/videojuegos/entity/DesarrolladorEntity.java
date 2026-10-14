package com.videojuegos.videojuegos.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Desarrollador")
public class DesarrolladorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Desarrollador")
    private Long idDesarrollador;

    @Column(name = "Nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "SitioWeb")
    private String sitioWeb;

    // mappedBy indica el nombre exacto de la variable que pusiste en ProductoEntity
    @OneToMany(mappedBy = "desarrollador")
    private List<ProductoEntity> productos;

    // --- GETTERS Y SETTERS ÚNICOS ---

    public Long getIdDesarrollador() {
        return idDesarrollador;
    }

    public void setIdDesarrollador(Long idDesarrollador) {
        this.idDesarrollador = idDesarrollador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public List<ProductoEntity> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoEntity> productos) {
        this.productos = productos;
    }
}