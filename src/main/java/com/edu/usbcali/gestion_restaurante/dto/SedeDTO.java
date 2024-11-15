package com.edu.usbcali.gestion_restaurante.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.edu.usbcali.gestion_restaurante.domain.Sede.Estado;
import com.edu.usbcali.gestion_restaurante.domain.Sede.TipoSede;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SedeDTO {
    private Integer idSede;
    private String nombre_sede;
    private String direccion_sede;
    private String telefono_contacto;
    private LocalDateTime fecha_apertura;
    private TipoSede tipo;       // Campo de tipo enumerado TipoSede
    private Estado estado;     // Campo de tipo enumerado Estado
}
