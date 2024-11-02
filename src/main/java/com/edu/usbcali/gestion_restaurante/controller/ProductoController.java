package com.edu.usbcali.gestion_restaurante.controller;

import com.edu.usbcali.gestion_restaurante.dto.ProductoDTO;
import com.edu.usbcali.gestion_restaurante.mapper.ProductoMapper;
import com.edu.usbcali.gestion_restaurante.repository.ProductoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @GetMapping(value = "/ping")
    public String pingPong() {
        return "pong";
    }

    @GetMapping(value = "/all")
    public List<ProductoDTO> getProductos() {
        return ProductoMapper.domainToDTOList(productoRepository.findAll());
    }
}
