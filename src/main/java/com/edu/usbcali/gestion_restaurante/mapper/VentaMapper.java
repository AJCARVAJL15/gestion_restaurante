package com.edu.usbcali.gestion_restaurante.mapper;

import com.edu.usbcali.gestion_restaurante.domain.Venta; // Cambiar a "Venta" con mayúscula inicial
import com.edu.usbcali.gestion_restaurante.dto.VentaDTO;

import java.util.List;
import java.util.stream.Collectors;

public class VentaMapper {

    public static VentaDTO domainToDTO(Venta venta) { // Cambiar a "Venta" con mayúscula inicial
        return VentaDTO.builder()
                .idVenta(venta.getId_venta())
                .idSede(venta.getSede() != null ? venta.getSede().getId_sede() : null)
                .idCajero(venta.getEmpleado() != null ? venta.getEmpleado().getId_empleado() : null)
                .fechaVenta(venta.getFecha_venta())
                .totalVenta(venta.getTotal_venta())
                .metodoPago(venta.getMetodo_pago() != null ? venta.getMetodo_pago().name() : null)
                .build();
    }

    public static Venta dTOToDomain(VentaDTO ventaDTO) { // Cambiar a "Venta" con mayúscula inicial
        Venta venta = Venta.builder() // Cambiar a "Venta" con mayúscula inicial
                .id_venta(ventaDTO.getIdVenta())
                .fecha_venta(ventaDTO.getFechaVenta())
                .total_venta(ventaDTO.getTotalVenta())
                .build();

        if (ventaDTO.getMetodoPago() != null) {
            venta.setMetodo_pago(Venta.MetodoPago.valueOf(ventaDTO.getMetodoPago())); // Cambiar a "Venta" con mayúscula inicial
        }

        return venta;
    }

    public static List<VentaDTO> domainToDTOList(List<Venta> ventas) { // Cambiar a "Venta" con mayúscula inicial
        return ventas.stream().map(VentaMapper::domainToDTO).collect(Collectors.toList());
    }

    public static List<Venta> dTOToDomainList(List<VentaDTO> ventasDTO) { // Cambiar a "Venta" con mayúscula inicial
        return ventasDTO.stream().map(VentaMapper::dTOToDomain).collect(Collectors.toList());
    }
}
