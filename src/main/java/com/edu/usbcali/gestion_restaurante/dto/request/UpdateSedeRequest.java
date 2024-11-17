package com.edu.usbcali.gestion_restaurante.dto.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.edu.usbcali.gestion_restaurante.domain.Sede.Estado;
import com.edu.usbcali.gestion_restaurante.domain.Sede.TipoSede;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSedeRequest {
     @NotNull(message = "El teléfono de contacto no puede ser null")
    @NotEmpty(message = "El teléfono de contacto no puede estar vacío")
    @Size(max = 20, message = "El teléfono de contacto no puede tener más de 20 caracteres")
    private String telefono_contacto;
    @NotNull(message = "El tipo de sede no puede ser null")
    private TipoSede tipo;
    @NotNull(message = "El estado de la sede no puede ser null")
    private Estado estado;
}
