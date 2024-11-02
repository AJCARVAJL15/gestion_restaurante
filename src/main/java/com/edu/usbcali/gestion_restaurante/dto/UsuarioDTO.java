package com.edu.usbcali.gestion_restaurante.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Integer idUsuario;
    private String nombreUsuario;
    private String contraseñaUsuario;
    private Integer idEmpleado;    // Referencia al empleado
    private String rol;            // Campo de tipo enumerado Rol
    private String estado;         // Campo de tipo enumerado Estado
}
