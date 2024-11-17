package com.edu.usbcali.gestion_restaurante.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.edu.usbcali.gestion_restaurante.domain.Empleado.Cargo;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CrearEmpleadoRequest {
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private LocalDateTime fechaContratacion;
    private BigDecimal salarioEmpleado;
    private Integer idSede;          // Referencia a la sede
    private Cargo cargo;  
}
