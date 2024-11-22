package com.edu.usbcali.gestion_restaurante.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.edu.usbcali.gestion_restaurante.domain.Empleado.Cargo;
import com.edu.usbcali.gestion_restaurante.domain.Sede;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmpleadoRequest {
    

    @Size(max = 20, message = "El nombre del empleado no puede tener más de 20 caracteres")
    private String nombreEmpleado;

  
    @Size(max = 20, message = "El apellido del empleado no puede tener más de 20 caracteres")
    private String apellidoEmpleado;

   
    private LocalDateTime fecha_contratacion;

    private BigDecimal salario_empleado;


    private Integer idSede;

    private Cargo cargo;
}
