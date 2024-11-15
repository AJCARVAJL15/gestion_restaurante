package com.edu.usbcali.gestion_restaurante.service.impl;

import org.springframework.stereotype.Service;

import com.edu.usbcali.gestion_restaurante.domain.Sede;
import com.edu.usbcali.gestion_restaurante.dto.SedeDTO;
import com.edu.usbcali.gestion_restaurante.dto.request.CrearSedeRequest;
import com.edu.usbcali.gestion_restaurante.mapper.SedeMapper;
import com.edu.usbcali.gestion_restaurante.repository.SedeRepository;
import com.edu.usbcali.gestion_restaurante.service.SedeService;

@Service
public class SedeServiceImpl implements SedeService{

    private final SedeRepository sedeRepository;

    public SedeServiceImpl(SedeRepository sedeRepository){
        this.sedeRepository = sedeRepository;
    }


    @Override
    public SedeDTO crearSede(CrearSedeRequest crearSedeRequest) throws Exception {


        //Validar que el objeto no sea null
        if(crearSedeRequest == null){
            throw new Exception("El objeto Sede no puede ser null");
        }
       
        //Convertir el objeto CrearSedeRequest a un objeto Sede
        Sede sede = SedeMapper.crearSedeRequestToDomain(crearSedeRequest);

        sede = sedeRepository.save(sede);
        SedeDTO sedeDTO = SedeMapper.domainToDTO(sede);

        System.out.println("crear sede"+ sedeDTO);

        return sedeDTO;
    }
    @Override
    public SedeDTO eliminarSede(int sedeId) throws Exception {
        // Validar que el ID sea válido
        if (sedeId <= 0) {
            throw new Exception("El ID de la sede debe ser mayor a 0");
        }

        // Buscar la sede por ID
        Sede sede = sedeRepository.findById(sedeId)
            .orElseThrow(() -> new Exception("No se encontró la sede con ID: " + sedeId));

        System.err.println(sede);

        // Eliminar la sede
        sedeRepository.delete(sede);

        // Convertir y retornar el DTO
        return SedeMapper.domainToDTO(sede);
    }

}
