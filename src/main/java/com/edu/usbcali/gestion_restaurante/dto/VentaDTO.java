package com.edu.usbcali.gestion_restaurante.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VentaDTO {
    private Integer idVenta;
    private Integer idSede;           // Referencia a la sede de la venta
    private Integer idCajero;         // Referencia al cajero (empleado) que realizó la venta
    private LocalDateTime fechaVenta;
    private BigDecimal totalVenta;
    private String metodoPago;        // Campo para el tipo de pago (EFECTIVO, TARJETA, TRANSFERENCIA)
}
