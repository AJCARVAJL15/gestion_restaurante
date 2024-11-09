package com.edu.usbcali.gestion_restaurante.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.usbcali.gestion_restaurante.mapper.VentaMapper;
import com.edu.usbcali.gestion_restaurante.repository.VentaRepository;

import java.util.List;
import com.edu.usbcali.gestion_restaurante.dto.VentaDTO;

@RestController
@RequestMapping("/venta")
public class VentaController {
    private final VentaRepository ventaRepository;

    public VentaController(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @GetMapping(value = "/ping")
    public String pingPong() {
        return "pong";
    }

    @GetMapping(value = "/all")
    public List<VentaDTO> getVentas() {
        return VentaMapper.domainToDTOList(ventaRepository.findAll());
    }
}
