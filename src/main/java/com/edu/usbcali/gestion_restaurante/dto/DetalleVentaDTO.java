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
public class DetalleVentaDTO {
    private Integer idDetalle;
    private Integer idVenta;        // Referencia a la venta
    private Integer idProducto;     // Referencia al producto
    private Integer cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;
}
