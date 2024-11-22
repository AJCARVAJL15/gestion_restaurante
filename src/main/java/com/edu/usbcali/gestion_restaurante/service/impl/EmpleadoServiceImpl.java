package com.edu.usbcali.gestion_restaurante.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.edu.usbcali.gestion_restaurante.domain.Empleado;
import com.edu.usbcali.gestion_restaurante.domain.Sede;
import com.edu.usbcali.gestion_restaurante.dto.EmpleadoDTO;
import com.edu.usbcali.gestion_restaurante.dto.request.CrearEmpleadoRequest;
import com.edu.usbcali.gestion_restaurante.dto.request.UpdateEmpleadoRequest;
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

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public EmpleadoDTO actualizarEmpleado(Integer idEmpleado, UpdateEmpleadoRequest updateEmpleadoRequest) throws Exception{
      
        Empleado empleado = findById(idEmpleado);

        Integer idSede = updateEmpleadoRequest.getIdSede();  // Suponiendo que UpdateEmpleadoRequest tiene un campo idSede
        if (idSede != null) {
            // Buscar la entidad Sede por id
            Sede sede = sedeRepository.findById(idSede)
                    .orElseThrow(() -> new Exception("Sede no encontrada con el id: " + idSede));
            
            // 3. Asignar la sede al empleado
            empleado.setSede(sede);
            System.out.println(empleado);

        }
        System.out.println(empleado);

        empleado=EmpleadoMapper.updateEmpleadoRequestToDomnain(empleado, updateEmpleadoRequest);
        System.out.println(empleado);

        empleado=empleadoRepository.save(empleado);

        return EmpleadoMapper.domainToDTO(empleado);


    } 
    
    @Transactional(readOnly = true)
    protected Empleado findById(Integer id) throws Exception {
        return empleadoRepository.findById(id)
                .orElseThrow(
                    () -> new Exception(
                        String.format("NO existe empleado con el id", id)
                    )
                );
    }

    }
