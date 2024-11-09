package com.edu.usbcali.gestion_restaurante.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.usbcali.gestion_restaurante.mapper.EmpleadoMapper;
import com.edu.usbcali.gestion_restaurante.repository.EmpleadoRepository;
import com.edu.usbcali.gestion_restaurante.dto.EmpleadoDTO;

import java.util.List;
@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoController(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @GetMapping(value = "/ping")
    public String pingPong() {
        return "pong";
    }

    @GetMapping(value = "/all")
    public List<EmpleadoDTO> getEmpleados() {
        return EmpleadoMapper.domainToDTOList(empleadoRepository.findAll());
    }
}
