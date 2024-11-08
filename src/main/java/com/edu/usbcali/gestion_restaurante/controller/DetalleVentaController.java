package com.edu.usbcali.gestion_restaurante.controller;

import com.edu.usbcali.gestion_restaurante.dto.DetalleVentaDTO;
import com.edu.usbcali.gestion_restaurante.mapper.DetalleVentaMapper;
import com.edu.usbcali.gestion_restaurante.repository.DetalleVentaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/detalleVenta")
public class DetalleVentaController {

    private final DetalleVentaRepository detalleVentaRepository;

    public DetalleVentaController(DetalleVentaRepository detalleVentaRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
    }


    @GetMapping(value = "/ping")
    public String pingPong() {
        return "pong";
    }

    @GetMapping(value = "/all")
    public List<DetalleVentaDTO> getDetalleVenta() {
        return DetalleVentaMapper.domainToDTOList(detalleVentaRepository.findAll());
    }

    
}
