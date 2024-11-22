package com.edu.usbcali.gestion_restaurante.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.usbcali.gestion_restaurante.domain.Empleado;
import com.edu.usbcali.gestion_restaurante.dto.EmpleadoDTO;
import com.edu.usbcali.gestion_restaurante.dto.request.CrearEmpleadoRequest;
import com.edu.usbcali.gestion_restaurante.dto.request.UpdateEmpleadoRequest;
import com.edu.usbcali.gestion_restaurante.mapper.EmpleadoMapper;
import com.edu.usbcali.gestion_restaurante.repository.EmpleadoRepository;
import com.edu.usbcali.gestion_restaurante.service.EmpleadoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/empleado")
@CrossOrigin("*")
public class EmpleadoController {

    private final EmpleadoRepository empleadoRepository;
    private final EmpleadoService empleadoService;
   
   
    public EmpleadoController(EmpleadoRepository empleadoRepository,EmpleadoService empleadoService) {
        this.empleadoRepository = empleadoRepository;
        this.empleadoService=empleadoService;
    }

    @GetMapping(value = "/ping")
    public String pingPong() {
        return "pong";
    }

    @GetMapping(value = "/all")
    public List<EmpleadoDTO> getEmpleados() {
        return EmpleadoMapper.domainToDTOList(empleadoRepository.findAll());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<EmpleadoDTO> crearEmpleado(@RequestBody CrearEmpleadoRequest crearEmpleadoRequest) throws Exception{
        EmpleadoDTO empleadoResponse=
                empleadoService.crearEmpleado(crearEmpleadoRequest);
        return ResponseEntity.ok(empleadoResponse);
    }

    @GetMapping("/buscar/{idSede}")
    public List<Empleado>  obtenerEmpleadosPorSede(@PathVariable Integer idSede) {
        return empleadoService.buscarEmpleados(idSede);
    }

    @PutMapping(value="/update/empleado/{idEmpleado}")
    public ResponseEntity<EmpleadoDTO> actualizarEmpleado(@PathVariable Integer idEmpleado,@RequestBody @Valid UpdateEmpleadoRequest updateEmpleadoRequest) throws Exception{
        EmpleadoDTO empleadoResponseDTO = empleadoService.actualizarEmpleado(idEmpleado, updateEmpleadoRequest);
        return ResponseEntity.ok(empleadoResponseDTO);
    }

 
}
