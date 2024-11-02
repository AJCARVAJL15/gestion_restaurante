package com.edu.usbcali.gestion_restaurante.mapper;

import com.edu.usbcali.gestion_restaurante.domain.empleado;
import com.edu.usbcali.gestion_restaurante.dto.EmpleadoDTO;

import java.util.List;
import java.util.stream.Collectors;

public class EmpleadoMapper {

    public static EmpleadoDTO domainToDTO(empleado emp) {
        return EmpleadoDTO.builder()
                .idEmpleado(emp.getId_empleado())
                .nombreEmpleado(emp.getNombre_empleado())
                .apellidoEmpleado(emp.getApellido_empleado())
                .fechaContratacion(emp.getFecha_contratacion())
                .salarioEmpleado(emp.getSalario_empleado())
                .idSede(emp.getSede().getId_sede()) // Asegúrate de que 'sede' no sea null
                .cargo(emp.getCargo() != null ? emp.getCargo().name() : null) // Convierte el enum a String
                .build();
    }

    public static empleado dTOToDomain(EmpleadoDTO empDTO) {
        empleado emp = empleado.builder()
                .id_empleado(empDTO.getIdEmpleado())
                .nombre_empleado(empDTO.getNombreEmpleado())
                .apellido_empleado(empDTO.getApellidoEmpleado())
                .fecha_contratacion(empDTO.getFechaContratacion())
                .salario_empleado(empDTO.getSalarioEmpleado())
                .build();
        
        // Asignar la sede y el cargo
        // Deberías tener un método para buscar la sede por id o recibir la sede completa
        // emp.setSede(findSedeById(empDTO.getIdSede())); // Este método debe ser implementado
        // emp.setCargo(empleado.Cargo.valueOf(empDTO.getCargo())); // Esto convierte de String a enum
        
        return emp;
    }

    public static List<EmpleadoDTO> domainToDTOList(List<empleado> empleados) {
        return empleados.stream().map(EmpleadoMapper::domainToDTO).collect(Collectors.toList());
    }

    public static List<empleado> dTOToDomainList(List<EmpleadoDTO> empleadosDTO) {
        return empleadosDTO.stream().map(EmpleadoMapper::dTOToDomain).collect(Collectors.toList());
    }
}
