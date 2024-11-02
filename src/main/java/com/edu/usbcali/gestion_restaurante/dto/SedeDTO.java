package com.edu.usbcali.gestion_restaurante.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SedeDTO {
    private Integer idSede;
    private String nombreSede;
    private String direccionSede;
    private String telefonoSede;
    private LocalDateTime fechaApertura;
    private String tipo;       // Campo de tipo enumerado TipoSede
    private String estado;     // Campo de tipo enumerado Estado
}
