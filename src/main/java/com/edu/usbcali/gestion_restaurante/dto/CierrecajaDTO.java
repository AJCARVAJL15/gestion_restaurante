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
public class CierrecajaDTO {
    private Integer idCierre;           // Atributo para el ID del cierre
    private LocalDateTime fechaCierre;  // Fecha del cierre
    private BigDecimal totalEfectivo;   // Total en efectivo
    private BigDecimal totalTarjeta;     // Total en tarjeta
    private BigDecimal totalTransferencia;// Total en transferencia
    private BigDecimal totalCierre;      // Total del cierre

    // Si quieres agregar referencias a la sede y empleado, considera que puedes agregar campos para ellos, pero ten en cuenta la consistencia.
    private Integer idSede;             // Referencia a la sede
    private Integer idEmpleado;          // Referencia al empleado
}
