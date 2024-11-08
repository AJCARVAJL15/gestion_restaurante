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
        //Validar que el nombre de la sede no exista
        if(crearSedeRequest.getNombre_sede() == null || crearSedeRequest.getNombre_sede().equals("")){
            throw new Exception("El nombre de la sede no puede ser null o estar vacío");
        }
        //Validar tamaño del nombre de la sede
        if(crearSedeRequest.getNombre_sede().length() > 100){
            throw new Exception("El nombre de la sede no puede tener más de 100 caracteres");
        }

        //Validar que la direccion de la sede no exista
        if(crearSedeRequest.getDireccion_sede() == null || crearSedeRequest.getDireccion_sede().equals("")){
            throw new Exception("La direccion de la sede no puede ser null o estar vacío");
        }

        //Validar tamaño de la direccion de la sede
        if(crearSedeRequest.getDireccion_sede().length() > 100){
            throw new Exception("La direccion de la sede no puede tener más de 100 caracteres");
        }

     

     

        //Validar que la fecha de apertura de la sede no exista
        if(crearSedeRequest.getFecha_apertura() == null){
            throw new Exception("La fecha de apertura de la sede no puede ser null");
        }

        //Validar que el tipo de sede no exista
        if(crearSedeRequest.getTipo() == null || crearSedeRequest.getTipo().equals("")){
            throw new Exception("El tipo de sede no puede ser null o estar vacío");
        }

        //Validar que el estado de la sede no exista
        if(crearSedeRequest.getEstado() == null || crearSedeRequest.getEstado().equals("")){
           throw new Exception("El estado de la sede no puede ser null o estar vacío");
      }

        //Convertir el objeto CrearSedeRequest a un objeto Sede
        Sede sede = SedeMapper.crearSedeRequestToDomain(crearSedeRequest);

        sede = sedeRepository.save(sede);
        SedeDTO sedeDTO = SedeMapper.domainToDTO(sede);

        System.out.println("crear sede"+ sedeDTO);

        return sedeDTO;
    }

}
