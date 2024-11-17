package com.edu.usbcali.gestion_restaurante.service;

import com.edu.usbcali.gestion_restaurante.dto.SedeDTO;
import com.edu.usbcali.gestion_restaurante.dto.request.CrearSedeRequest;
import com.edu.usbcali.gestion_restaurante.dto.request.UpdateSedeRequest;

public interface  SedeService {
    public SedeDTO crearSede(CrearSedeRequest crearSedeRequest) throws Exception;
    public SedeDTO eliminarSede(Integer sedeId) throws Exception;
    public SedeDTO actualizarSede(Integer sedeId, UpdateSedeRequest updateSedeRequest) throws Exception;
}
