package com.edu.usbcali.gestion_restaurante.service;


import java.util.List;

import com.edu.usbcali.gestion_restaurante.domain.Empleado;
import com.edu.usbcali.gestion_restaurante.dto.EmpleadoDTO;
import com.edu.usbcali.gestion_restaurante.dto.request.CrearEmpleadoRequest;

public interface EmpleadoService {
    public EmpleadoDTO crearEmpleado(CrearEmpleadoRequest crearEmpleadoRequest) throws Exception;
    public List<Empleado> buscarEmpleados(Integer idSede);
}
