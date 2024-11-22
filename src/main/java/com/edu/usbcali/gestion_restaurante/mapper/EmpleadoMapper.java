package com.edu.usbcali.gestion_restaurante.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.edu.usbcali.gestion_restaurante.domain.Empleado;
import com.edu.usbcali.gestion_restaurante.domain.Sede;
import com.edu.usbcali.gestion_restaurante.dto.EmpleadoDTO;
import com.edu.usbcali.gestion_restaurante.dto.request.CrearEmpleadoRequest;
import com.edu.usbcali.gestion_restaurante.dto.request.UpdateEmpleadoRequest;

public class EmpleadoMapper {

    public static EmpleadoDTO domainToDTO(Empleado emp) {
        return EmpleadoDTO.builder()
                .idEmpleado(emp.getId_empleado())
                .nombreEmpleado(emp.getNombreEmpleado())
                .apellidoEmpleado(emp.getApellidoEmpleado())
                .fechaContratacion(emp.getFecha_contratacion())
                .salarioEmpleado(emp.getSalario_empleado())
                .idSede(emp.getSede().getId_sede()) // Asegúrate de que 'sede' no sea null
                .cargo(emp.getCargo()) // Convierte el enum a String
                .build();
    }

    public static Empleado dTOToDomain(EmpleadoDTO empDTO) {
        Empleado emp = Empleado.builder()
                .id_empleado(empDTO.getIdEmpleado())
                .nombreEmpleado(empDTO.getNombreEmpleado())
                .apellidoEmpleado(empDTO.getApellidoEmpleado())
                .fecha_contratacion(empDTO.getFechaContratacion())
                .salario_empleado(empDTO.getSalarioEmpleado())
                .build();
        
        // Asignar la sede y el cargo
        // Deberías tener un método para buscar la sede por id o recibir la sede completa
        // emp.setSede(findSedeById(empDTO.getIdSede())); // Este método debe ser implementado
        // emp.setCargo(empleado.Cargo.valueOf(empDTO.getCargo())); // Esto convierte de String a enum
        
        return emp;
    }

    public static List<EmpleadoDTO> domainToDTOList(List<Empleado> empleados) {
        return empleados.stream().map(EmpleadoMapper::domainToDTO).collect(Collectors.toList());
    }

    public static List<Empleado> dTOToDomainList(List<EmpleadoDTO> empleadosDTO) {
        return empleadosDTO.stream().map(EmpleadoMapper::dTOToDomain).collect(Collectors.toList());
    }

    public static Empleado crearEmpleadoRequestToDomain(CrearEmpleadoRequest crearEmpleadoRequest){
        return Empleado.builder()
        .nombreEmpleado(crearEmpleadoRequest.getNombreEmpleado())
        .apellidoEmpleado(crearEmpleadoRequest.getApellidoEmpleado())
        .fecha_contratacion(crearEmpleadoRequest.getFechaContratacion())
        .salario_empleado(crearEmpleadoRequest.getSalarioEmpleado())
        .cargo(crearEmpleadoRequest.getCargo())
        .build();       
    }

    public static Empleado updateEmpleadoRequestToDomnain(Empleado empleado,UpdateEmpleadoRequest updateEmpleadoRequest){
     // Actualizamos los campos del empleado con los valores del request
    if (updateEmpleadoRequest.getNombreEmpleado() != null) {
        empleado.setNombreEmpleado(updateEmpleadoRequest.getNombreEmpleado());
    }
    
    if (updateEmpleadoRequest.getApellidoEmpleado() != null) {
        empleado.setApellidoEmpleado(updateEmpleadoRequest.getApellidoEmpleado());
    }

    if (updateEmpleadoRequest.getFecha_contratacion() != null) {
        empleado.setFecha_contratacion(updateEmpleadoRequest.getFecha_contratacion());
    }

    if (updateEmpleadoRequest.getSalario_empleado() != null) {
        empleado.setSalario_empleado(updateEmpleadoRequest.getSalario_empleado());
    }

    if (updateEmpleadoRequest.getCargo() != null) {
        empleado.setCargo(updateEmpleadoRequest.getCargo());
    }

    return empleado;
    }
}
