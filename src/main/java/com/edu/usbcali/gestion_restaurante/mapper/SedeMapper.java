package com.edu.usbcali.gestion_restaurante.mapper;

import java.time.LocalDateTime; // Cambiar a "Sede" con mayúscula inicial
import java.util.List;
import java.util.stream.Collectors;

import com.edu.usbcali.gestion_restaurante.domain.Sede;
import com.edu.usbcali.gestion_restaurante.dto.SedeDTO;
import com.edu.usbcali.gestion_restaurante.dto.request.CrearSedeRequest;
import com.edu.usbcali.gestion_restaurante.dto.request.UpdateSedeRequest;

public class SedeMapper {

    public static SedeDTO domainToDTO(Sede sede) { // Cambiar a "Sede" con mayúscula inicial
        return SedeDTO.builder()
                .idSede(sede.getId_sede())
                .nombre_sede(sede.getNombre_sede())
                .direccion_sede(sede.getDireccion_sede())
                .telefono_contacto(sede.getTelefono_contacto())
                .fecha_apertura(sede.getFecha_apertura())
                .tipo(sede.getTipo() ) // Convierte el enum a String
                .estado(sede.getEstado() ) // Convierte el enum a String
                .build();
    }

    public static Sede dTOToDomain(SedeDTO sedeDTO) { // Cambiar a "Sede" con mayúscula inicial
        Sede sede = Sede.builder() // Cambiar a "Sede" con mayúscula inicial
                .id_sede(sedeDTO.getIdSede())
                .nombre_sede(sedeDTO.getNombre_sede())
                .direccion_sede(sedeDTO.getDireccion_sede())    
                .telefono_contacto(sedeDTO.getTelefono_contacto())
                .fecha_apertura(sedeDTO.getFecha_apertura())
                .tipo(sedeDTO.getTipo())
                .estado(sedeDTO.getEstado())
                .build();

        // Asignar tipo y estado si no son nulos
        //if (sedeDTO.getTipo() != null) {
          //  sede.setTipo(Sede.TipoSede.valueOf(sedeDTO.getTipo())); // Cambiar a "Sede" con mayúscula inicial
        //}
        //if (sedeDTO.getEstado() != null) {
        //    sede.setEstado(Sede.Estado.valueOf(sedeDTO.getEstado())); // Cambiar a "Sede" con mayúscula inicial
        //}

        return sede;
    }

    public static List<SedeDTO> domainToDTOList(List<Sede> sedes) { // Cambiar a "Sede" con mayúscula inicial
        return sedes.stream().map(SedeMapper::domainToDTO).collect(Collectors.toList());
    }

    public static List<Sede> dTOToDomainList(List<SedeDTO> sedesDTO) { // Cambiar a "Sede" con mayúscula inicial
        return sedesDTO.stream().map(SedeMapper::dTOToDomain).collect(Collectors.toList());
    }

    public static Sede crearSedeRequestToDomain(CrearSedeRequest crearSedeRequest){

        return Sede.builder()
            .nombre_sede(crearSedeRequest.getNombre_sede())
            .direccion_sede(crearSedeRequest.getDireccion_sede())
            .fecha_apertura(LocalDateTime.now())
            .telefono_contacto(crearSedeRequest.getTelefono_contacto())
            .tipo(crearSedeRequest.getTipo() )
            .estado(crearSedeRequest.getEstado())
            .build();
    }

    public static Sede UpdateSedeRequestToDomain(Sede sede, UpdateSedeRequest updateSedeRequest){
        sede.setTelefono_contacto(updateSedeRequest.getTelefono_contacto());
        sede.setEstado(updateSedeRequest.getEstado());
        sede.setTipo(updateSedeRequest.getTipo());
        return sede;
    }
}
