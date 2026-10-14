package com.videojuegos.videojuegos.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrdenDTO {
    private Long idOrden;
    private Long idUsuario; // Recibimos solo el ID del usuario desde el frontend
    private LocalDateTime fecha;
    private BigDecimal total;

    public Long getIdOrden() { return idOrden; }
    public void setIdOrden(Long idOrden) { this.idOrden = idOrden; }

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
}