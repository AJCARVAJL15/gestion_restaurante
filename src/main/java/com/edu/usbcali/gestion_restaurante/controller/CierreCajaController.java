package com.edu.usbcali.gestion_restaurante.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.usbcali.gestion_restaurante.mapper.CierrecajaMapper;
import com.edu.usbcali.gestion_restaurante.repository.CierrecajaRepository;
import com.edu.usbcali.gestion_restaurante.dto.CierrecajaDTO;

import java.util.List;

@RestController
@RequestMapping("/cierre-caja")
public class CierreCajaController {

    private final CierrecajaRepository cierreCajaRepository;

    public CierreCajaController(CierrecajaRepository cierreCajaRepository) {
        this.cierreCajaRepository = cierreCajaRepository;
    }

    @GetMapping(value = "/ping")
    public String pingPong() {
        return "pong";
    }

    @GetMapping(value = "/all")
    public List<CierrecajaDTO> getCierreCajas() {
        return CierrecajaMapper.domainToDTOList(cierreCajaRepository.findAll());
    }
}
