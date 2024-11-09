package com.edu.usbcali.gestion_restaurante.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.edu.usbcali.gestion_restaurante.repository.ReportesRepository;
import com.edu.usbcali.gestion_restaurante.dto.ReportesDTO;
import com.edu.usbcali.gestion_restaurante.mapper.ReportesMapper;

import java.util.List;

@RestController
@RequestMapping("/reporte")
public class ReporteController {
    private final ReportesRepository reporteRepository;
  
    public ReporteController(ReportesRepository reporteRepository) {
        this.reporteRepository = reporteRepository;
    }

    @GetMapping(value = "/ping")
    public String pingPong() {
        return "pong";
    }

    @GetMapping(value = "/all")
    public List<ReportesDTO> getReportes() {
       return ReportesMapper.domainToDTOList(reporteRepository.findAll());
    }
}
