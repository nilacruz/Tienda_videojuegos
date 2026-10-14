package com.videojuegos.videojuegos.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Set; // ¡Importante para que reconozca el Set!

@Entity
@Table(name = "Producto")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_producto")
    private Long idProducto;

    // Relación Muchos a Muchos con Categoría
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "Producto_Categoria", // El nombre de tabla intermedia en SQL
            joinColumns = @JoinColumn(name = "Id_producto"), // La llave foránea hacia Producto
            inverseJoinColumns = @JoinColumn(name = "Id_categoria") // La llave foránea hacia Categoria
    )
    private Set<CategoriaEntity> categorias;

    // Relación Muchos a Uno con Desarrollador
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Desarrollador", nullable = false) // Llave foránea
    private DesarrolladorEntity desarrollador;

    @Column(name = "Nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "Descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "Precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "Img")
    private String img;

    @Column(name = "Especificaciones", columnDefinition = "JSON")
    private String especificaciones;

    @Column(name = "AñoEmision")
    private Integer anioEmision;



    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Set<CategoriaEntity> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<CategoriaEntity> categorias) {
        this.categorias = categorias;
    }

    public DesarrolladorEntity getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(DesarrolladorEntity desarrollador) {
        this.desarrollador = desarrollador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }

    public Integer getAnioEmision() {
        return anioEmision;
    }

    public void setAnioEmision(Integer anioEmision) {
        this.anioEmision = anioEmision;
    }
}