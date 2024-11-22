package com.edu.usbcali.gestion_restaurante.service.impl;

import com.edu.usbcali.gestion_restaurante.domain.Sede;
import com.edu.usbcali.gestion_restaurante.dto.SedeDTO;
import com.edu.usbcali.gestion_restaurante.dto.request.CrearSedeRequest;
import com.edu.usbcali.gestion_restaurante.dto.request.UpdateSedeRequest;
import com.edu.usbcali.gestion_restaurante.mapper.SedeMapper;
import com.edu.usbcali.gestion_restaurante.repository.SedeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SedeServiceImplTest {

    @Mock
    private SedeRepository sedeRepository;

    @InjectMocks
    private SedeServiceImpl sedeService;

    private Sede sede;
    private SedeDTO sedeDTO;
    private CrearSedeRequest crearSedeRequest;
    private UpdateSedeRequest updateSedeRequest;

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

        sedeDTO = SedeMapper.domainToDTO(sede);

        crearSedeRequest = CrearSedeRequest.builder()
                .nombre_sede("Sede Nueva")
                .direccion_sede("Calle Nueva")
                .telefono_contacto("0987654321")
                .tipo(Sede.TipoSede.Franquicia)
                .estado(Sede.Estado.Mantenimiento)
                .build();

        updateSedeRequest = UpdateSedeRequest.builder()
                .telefono_contacto("123123123")
                .tipo(Sede.TipoSede.Propia)
                .estado(Sede.Estado.Cerrada)
                .build();
    }

    @Test
    void testCrearSede() throws Exception {
        when(sedeRepository.save(any(Sede.class))).thenReturn(sede);

        SedeDTO createdSede = sedeService.crearSede(crearSedeRequest);

        assertNotNull(createdSede);
        assertEquals("Sede Test", createdSede.getNombre_sede());
        assertEquals("Calle Test", createdSede.getDireccion_sede());

        verify(sedeRepository, times(1)).save(any(Sede.class));
    }

    @Test
    void testEliminarSede() throws Exception {
        when(sedeRepository.findById(1)).thenReturn(Optional.of(sede));

        SedeDTO deletedSede = sedeService.eliminarSede(1);

        assertNotNull(deletedSede);
        assertEquals(sede.getId_sede(), deletedSede.getIdSede());

        verify(sedeRepository, times(1)).delete(sede);
    }

    @Test
    void testEliminarSedeThrowsException() {
        when(sedeRepository.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(Exception.class, () -> sedeService.eliminarSede(1));

        assertEquals("No se encontró la sede con ID: 1", exception.getMessage());
    }

    @Test
    void testActualizarSede() throws Exception {
        when(sedeRepository.findById(1)).thenReturn(Optional.of(sede));
        when(sedeRepository.save(any(Sede.class))).thenReturn(sede);

        SedeDTO updatedSede = sedeService.actualizarSede(1, updateSedeRequest);

        assertNotNull(updatedSede);
        assertEquals(sede.getTelefono_contacto(), updatedSede.getTelefono_contacto());

        verify(sedeRepository, times(1)).save(any(Sede.class));
    }

    @Test
    void testActualizarSedeThrowsException() {
        when(sedeRepository.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(Exception.class, () -> sedeService.actualizarSede(1, updateSedeRequest));

        assertEquals("No existe categoria por el id", exception.getMessage());
    }
}
