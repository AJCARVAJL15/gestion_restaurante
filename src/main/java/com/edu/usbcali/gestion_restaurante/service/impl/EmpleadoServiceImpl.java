package com.edu.usbcali.gestion_restaurante.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.edu.usbcali.gestion_restaurante.domain.Empleado;
import com.edu.usbcali.gestion_restaurante.domain.Sede;
import com.edu.usbcali.gestion_restaurante.dto.EmpleadoDTO;
import com.edu.usbcali.gestion_restaurante.dto.request.CrearEmpleadoRequest;
import com.edu.usbcali.gestion_restaurante.mapper.EmpleadoMapper;
import com.edu.usbcali.gestion_restaurante.repository.EmpleadoRepository;
import com.edu.usbcali.gestion_restaurante.repository.SedeRepository;
import com.edu.usbcali.gestion_restaurante.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private EmpleadoRepository empleadoRepository;
    private SedeRepository sedeRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository,SedeRepository sedeRepository){
        this.empleadoRepository=empleadoRepository;
        this.sedeRepository=sedeRepository;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
     public EmpleadoDTO crearEmpleado(CrearEmpleadoRequest crearEmpleadoRequest) throws Exception{


        if(crearEmpleadoRequest==null){
            throw new Exception("Objeto vacio para crear");
        }

        Sede sede = sedeRepository.findById(crearEmpleadoRequest.getIdSede())
            .orElseThrow(
                ()->new Exception(String.format("No existe sede",crearEmpleadoRequest.getIdSede()))
            );

        Empleado empleadoExiste=empleadoRepository.findByNombreEmpleadoAndApellidoEmpleadoAndSede(crearEmpleadoRequest.getNombreEmpleado(),crearEmpleadoRequest.getApellidoEmpleado(), sede);

        if (empleadoExiste != null) {
            throw new Exception("Ya existe un empleado con el mismo nombre y apellido en esta sede.");
        }
        

         Empleado empleado=EmpleadoMapper.crearEmpleadoRequestToDomain(crearEmpleadoRequest);
         empleado.setSede(sede);

         empleado=empleadoRepository.save(empleado);

        return EmpleadoMapper.domainToDTO(empleado);
     }

    @Override
    public List<Empleado> buscarEmpleados(Integer idSede){
        return empleadoRepository.findById_sede(idSede);
    }
     

    }
