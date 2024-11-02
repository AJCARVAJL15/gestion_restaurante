package com.edu.usbcali.gestion_restaurante.mapper;

import com.edu.usbcali.gestion_restaurante.domain.Usuario; // Clase Usuario
import com.edu.usbcali.gestion_restaurante.domain.Empleado; // Asegúrate de importar la clase Empleado
import com.edu.usbcali.gestion_restaurante.dto.UsuarioDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {

    public static UsuarioDTO domainToDTO(Usuario usuario) { // Clase Usuario
        return UsuarioDTO.builder()
                .idUsuario(usuario.getId_usuario())
                .nombreUsuario(usuario.getNombre_usuario())
                .contraseñaUsuario(usuario.getContraseña_usuario())
                .idEmpleado(usuario.getEmpleado() != null ? usuario.getEmpleado().getId_empleado() : null) // Obtener el id del empleado
                .rol(usuario.getRol() != null ? usuario.getRol().name() : null) // Convierte el enum a String
                .estado(usuario.getEstado() != null ? usuario.getEstado().name() : null) // Convierte el enum a String
                .build();
    }

    public static Usuario dTOToDomain(UsuarioDTO usuarioDTO) { // Clase Usuario
        Usuario usuario = Usuario.builder() // Clase Usuario
                .id_usuario(usuarioDTO.getIdUsuario())
                .nombre_usuario(usuarioDTO.getNombreUsuario())
                .contraseña_usuario(usuarioDTO.getContraseñaUsuario())
                .build();

        // Asignar empleado, rol y estado si no son nulos
        if (usuarioDTO.getIdEmpleado() != null) {
            Empleado empleado = new Empleado();
            empleado.setId_empleado(usuarioDTO.getIdEmpleado());
            usuario.setEmpleado(empleado);
        }

        if (usuarioDTO.getRol() != null) {
            usuario.setRol(Usuario.Rol.valueOf(usuarioDTO.getRol())); // Clase Usuario
        }

        if (usuarioDTO.getEstado() != null) {
            usuario.setEstado(Usuario.Estado.valueOf(usuarioDTO.getEstado())); // Clase Usuario
        }

        return usuario;
    }

    public static List<UsuarioDTO> domainToDTOList(List<Usuario> usuarios) { // Clase Usuario
        return usuarios.stream().map(UsuarioMapper::domainToDTO).collect(Collectors.toList());
    }

    public static List<Usuario> dTOToDomainList(List<UsuarioDTO> usuariosDTO) { // Clase Usuario
        return usuariosDTO.stream().map(UsuarioMapper::dTOToDomain).collect(Collectors.toList());
    }
}
