package com.edu.usbcali.gestion_restaurante.mapper;

import com.edu.usbcali.gestion_restaurante.domain.Sede; // Cambiar a "Sede" con mayúscula inicial
import com.edu.usbcali.gestion_restaurante.dto.SedeDTO;

import java.util.List;
import java.util.stream.Collectors;

public class SedeMapper {

    public static SedeDTO domainToDTO(Sede sede) { // Cambiar a "Sede" con mayúscula inicial
        return SedeDTO.builder()
                .idSede(sede.getId_sede())
                .nombreSede(sede.getNombre_sede())
                .direccionSede(sede.getDireccion_sede())
                .telefonoSede(sede.getTelefono_sede())
                .fechaApertura(sede.getFecha_apertura())
                .tipo(sede.getTipo() != null ? sede.getTipo().name() : null) // Convierte el enum a String
                .estado(sede.getEstado() != null ? sede.getEstado().name() : null) // Convierte el enum a String
                .build();
    }

    public static Sede dTOToDomain(SedeDTO sedeDTO) { // Cambiar a "Sede" con mayúscula inicial
        Sede sede = Sede.builder() // Cambiar a "Sede" con mayúscula inicial
                .id_sede(sedeDTO.getIdSede())
                .nombre_sede(sedeDTO.getNombreSede())
                .direccion_sede(sedeDTO.getDireccionSede())
                .telefono_sede(sedeDTO.getTelefonoSede())
                .fecha_apertura(sedeDTO.getFechaApertura())
                .build();

        // Asignar tipo y estado si no son nulos
        if (sedeDTO.getTipo() != null) {
            sede.setTipo(Sede.TipoSede.valueOf(sedeDTO.getTipo())); // Cambiar a "Sede" con mayúscula inicial
        }
        if (sedeDTO.getEstado() != null) {
            sede.setEstado(Sede.Estado.valueOf(sedeDTO.getEstado())); // Cambiar a "Sede" con mayúscula inicial
        }

        return sede;
    }

    public static List<SedeDTO> domainToDTOList(List<Sede> sedes) { // Cambiar a "Sede" con mayúscula inicial
        return sedes.stream().map(SedeMapper::domainToDTO).collect(Collectors.toList());
    }

    public static List<Sede> dTOToDomainList(List<SedeDTO> sedesDTO) { // Cambiar a "Sede" con mayúscula inicial
        return sedesDTO.stream().map(SedeMapper::dTOToDomain).collect(Collectors.toList());
    }
}
