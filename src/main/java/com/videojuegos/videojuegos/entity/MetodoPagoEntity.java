package com.videojuegos.videojuegos.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Metodo_de_Pago")
public class MetodoPagoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_MPago")
    private Long idMPago;

    @Column(name = "Nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "Activo", nullable = false)
    private Boolean activo;

    public Long getIdMPago() { return idMPago; }
    public void setIdMPago(Long idMPago) { this.idMPago = idMPago; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
}