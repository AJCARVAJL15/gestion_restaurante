package com.edu.usbcali.gestion_restaurante.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.usbcali.gestion_restaurante.dto.SedeDTO;
import com.edu.usbcali.gestion_restaurante.dto.request.CrearSedeRequest;
import com.edu.usbcali.gestion_restaurante.mapper.SedeMapper;
import com.edu.usbcali.gestion_restaurante.repository.SedeRepository;
import com.edu.usbcali.gestion_restaurante.service.SedeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sede")
public class SedeController {

    private final SedeRepository sedeRepository;
    private final SedeService sedeService;

    public SedeController(SedeRepository sedeRepository, SedeService sedeService) {
        this.sedeRepository = sedeRepository;
        this.sedeService = sedeService;
    }

    @GetMapping(value = "/ping")
    public String pingPong() {
        return "pong";
    }

    @GetMapping(value = "/all")
    public List<SedeDTO> getSedes() {
        return SedeMapper.domainToDTOList(sedeRepository.findAll());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<SedeDTO> crearSede(@RequestBody @Valid CrearSedeRequest crearSedeRequest) throws Exception {
        SedeDTO sederesponSedeDTO = sedeService.crearSede(crearSedeRequest);
        return ResponseEntity.ok(sederesponSedeDTO);
    }
}
