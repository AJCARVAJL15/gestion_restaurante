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
public class EmpleadoDTO {
    private Integer idEmpleado;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private LocalDateTime fechaContratacion;
    private BigDecimal salarioEmpleado;
    private Integer idSede;          // Referencia a la sede
    private String cargo;            // Campo de tipo enumerado Cargo
}
