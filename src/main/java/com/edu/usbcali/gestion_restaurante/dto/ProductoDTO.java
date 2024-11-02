package com.edu.usbcali.gestion_restaurante.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private String categoria;
    private String estado;      // Campo de tipo enumerado EstadoProducto
}
