package com.videojuegos.videojuegos.dto;

public class MetodoPagoDTO {
    private Long idMPago;
    private String nombre;
    private Boolean activo;

    public Long getIdMPago() { return idMPago; }
    public void setIdMPago(Long idMPago) { this.idMPago = idMPago; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
}