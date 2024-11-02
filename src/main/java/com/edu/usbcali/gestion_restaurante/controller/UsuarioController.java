package com.edu.usbcali.gestion_restaurante.controller;

import com.edu.usbcali.gestion_restaurante.dto.UsuarioDTO;
import com.edu.usbcali.gestion_restaurante.mapper.UsuarioMapper;
import com.edu.usbcali.gestion_restaurante.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping(value = "/ping")
    public String pingPong() {
        return "pong";
    }

    @GetMapping(value = "/all")
    public List<UsuarioDTO> getUsuarios() {
        return UsuarioMapper.domainToDTOList(usuarioRepository.findAll());
    }
}
