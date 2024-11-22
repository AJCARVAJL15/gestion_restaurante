package com.edu.usbcali.gestion_restaurante.service.impl;

import com.edu.usbcali.gestion_restaurante.domain.Empleado;
import com.edu.usbcali.gestion_restaurante.domain.Sede;
import com.edu.usbcali.gestion_restaurante.dto.EmpleadoDTO;
import com.edu.usbcali.gestion_restaurante.dto.request.CrearEmpleadoRequest;
import com.edu.usbcali.gestion_restaurante.dto.request.UpdateEmpleadoRequest;
import com.edu.usbcali.gestion_restaurante.mapper.EmpleadoMapper;
import com.edu.usbcali.gestion_restaurante.repository.EmpleadoRepository;
import com.edu.usbcali.gestion_restaurante.repository.SedeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;  // Importar List

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmpleadoServiceImplTest {

    @Mock
    private EmpleadoRepository empleadoRepository;

    @Mock
    private SedeRepository sedeRepository;

    @InjectMocks
    private EmpleadoServiceImpl empleadoService;

    private Empleado empleado;
    private EmpleadoDTO empleadoDTO;
    private CrearEmpleadoRequest crearEmpleadoRequest;
    private UpdateEmpleadoRequest updateEmpleadoRequest;
    private Sede sede;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        sede = Sede.builder()
                .id_sede(1)
                .nombre_sede("Sede Test")
                .direccion_sede("Calle Test")
                .fecha_apertura(LocalDateTime.now())
                .telefono_contacto("1234567890")
                .tipo(Sede.TipoSede.Propia)
                .estado(Sede.Estado.Operativa)
                .build();

        empleado = Empleado.builder()
                .id_empleado(1)
                .nombreEmpleado("Empleado Test")
                .apellidoEmpleado("Test Apellido")
                .fecha_contratacion(LocalDateTime.now())
                .salario_empleado(new BigDecimal("1000"))
                .sede(sede)
                .cargo(Empleado.Cargo.Cocinero)
                .build();

        empleadoDTO = EmpleadoMapper.domainToDTO(empleado);

        crearEmpleadoRequest = CrearEmpleadoRequest.builder()
                .nombreEmpleado("Empleado Nuevo")
                .apellidoEmpleado("Nuevo Apellido")
                .fechaContratacion(LocalDateTime.now())
                .salarioEmpleado(new BigDecimal("1200"))
                .cargo(Empleado.Cargo.Gerente)
                .idSede(1)
                .build();

        updateEmpleadoRequest = UpdateEmpleadoRequest.builder()
                .nombreEmpleado("Empleado Actualizado")
                .apellidoEmpleado("Apellido Actualizado")
                .fecha_contratacion(LocalDateTime.now())
                .salario_empleado(new BigDecimal("1500"))
                .cargo(Empleado.Cargo.Mesero)
                .idSede(1)
                .build();
    }

    @Test
    void testCrearEmpleado() throws Exception {
        when(sedeRepository.findById(1)).thenReturn(Optional.of(sede));
        when(empleadoRepository.findByNombreEmpleadoAndApellidoEmpleadoAndSede(anyString(), anyString(), any(Sede.class)))
                .thenReturn(null);

        // Crear un nuevo empleado con los datos del request
        Empleado nuevoEmpleado = Empleado.builder()
                .id_empleado(1)
                .nombreEmpleado("Empleado Nuevo")
                .apellidoEmpleado("Nuevo Apellido")
                .fecha_contratacion(LocalDateTime.now())
                .salario_empleado(new BigDecimal("1200"))
                .sede(sede)
                .cargo(Empleado.Cargo.Gerente)
                .build();

        when(empleadoRepository.save(any(Empleado.class))).thenReturn(nuevoEmpleado);

        EmpleadoDTO createdEmpleado = empleadoService.crearEmpleado(crearEmpleadoRequest);

        assertNotNull(createdEmpleado);
        assertEquals("Empleado Nuevo", createdEmpleado.getNombreEmpleado());
        assertEquals("Nuevo Apellido", createdEmpleado.getApellidoEmpleado());

        verify(sedeRepository, times(1)).findById(1);
        verify(empleadoRepository, times(1)).save(any(Empleado.class));
    }

    @Test
    void testCrearEmpleadoThrowsExceptionWhenSedeNotFound() {
        when(sedeRepository.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(Exception.class, () -> empleadoService.crearEmpleado(crearEmpleadoRequest));

        assertEquals("No existe sede", exception.getMessage());
        verify(sedeRepository, times(1)).findById(1);
    }

    @Test
    void testCrearEmpleadoThrowsExceptionWhenEmployeeAlreadyExists() throws Exception {
        when(sedeRepository.findById(1)).thenReturn(Optional.of(sede));
        when(empleadoRepository.findByNombreEmpleadoAndApellidoEmpleadoAndSede(anyString(), anyString(), any(Sede.class)))
                .thenReturn(empleado);

        Exception exception = assertThrows(Exception.class, () -> empleadoService.crearEmpleado(crearEmpleadoRequest));

        assertEquals("Ya existe un empleado con el mismo nombre y apellido en esta sede.", exception.getMessage());
    }

    @Test
    void testActualizarEmpleado() throws Exception {
        when(empleadoRepository.findById(1)).thenReturn(Optional.of(empleado));
        when(sedeRepository.findById(1)).thenReturn(Optional.of(sede));
        when(empleadoRepository.save(any(Empleado.class))).thenReturn(empleado);

        EmpleadoDTO updatedEmpleado = empleadoService.actualizarEmpleado(1, updateEmpleadoRequest);

        assertNotNull(updatedEmpleado);
        assertEquals("Empleado Actualizado", updatedEmpleado.getNombreEmpleado());
        assertEquals("Apellido Actualizado", updatedEmpleado.getApellidoEmpleado());

        verify(empleadoRepository, times(1)).save(any(Empleado.class));
    }

    @Test
    void testActualizarEmpleadoThrowsExceptionWhenEmployeeNotFound() {
        when(empleadoRepository.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(Exception.class, () -> empleadoService.actualizarEmpleado(1, updateEmpleadoRequest));

        assertEquals("NO existe empleado con el id", exception.getMessage());
    }

    @Test
    void testBuscarEmpleados() {
        when(empleadoRepository.findById_sede(1)).thenReturn(List.of(empleado));

        List<Empleado> empleados = empleadoService.buscarEmpleados(1);

        assertNotNull(empleados);
        assertFalse(empleados.isEmpty());  // El método isEmpty() ya estará disponible
        assertEquals(1, empleados.size());

        verify(empleadoRepository, times(1)).findById_sede(1);
    }
}
