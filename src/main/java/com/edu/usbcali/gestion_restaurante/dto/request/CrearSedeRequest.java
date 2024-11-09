package com.edu.usbcali.gestion_restaurante.dto.request;
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
public class CrearSedeRequest {
    private String nombre_sede;
    private String direccion_sede;
    private LocalDateTime fecha_apertura;
    private TipoSede tipo;
    private Estado estado;
}
