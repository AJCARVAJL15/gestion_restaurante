package com.edu.usbcali.gestion_restaurante.service;

import com.edu.usbcali.gestion_restaurante.dto.SedeDTO;
import com.edu.usbcali.gestion_restaurante.dto.request.CrearSedeRequest;

public interface  SedeService {
    public SedeDTO crearSede(CrearSedeRequest crearSedeRequest) throws Exception;
}
