package com.edu.usbcali.gestion_restaurante.mapper;

import com.edu.usbcali.gestion_restaurante.domain.venta;
import com.edu.usbcali.gestion_restaurante.dto.VentaDTO;

import java.util.List;
import java.util.stream.Collectors;

public class VentaMapper {

    public static VentaDTO domainToDTO(venta venta) {
        return VentaDTO.builder()
                .idVenta(venta.getId_venta())
                .idSede(venta.getSede() != null ? venta.getSede().getId_sede() : null)
                .idCajero(venta.getEmpleado() != null ? venta.getEmpleado().getId_empleado() : null)
                .fechaVenta(venta.getFecha_venta())
                .totalVenta(venta.getTotal_venta())
                .metodoPago(venta.getMetodo_pago() != null ? venta.getMetodo_pago().name() : null)
                .build();
    }

    public static venta dTOToDomain(VentaDTO ventaDTO) {
        venta venta = venta.builder()
                .id_venta(ventaDTO.getIdVenta())
                .fecha_venta(ventaDTO.getFechaVenta())
                .total_venta(ventaDTO.getTotalVenta())
                .build();

        if (ventaDTO.getMetodoPago() != null) {
            venta.setMetodo_pago(venta.MetodoPago.valueOf(ventaDTO.getMetodoPago()));
        }

        return venta;
    }

    public static List<VentaDTO> domainToDTOList(List<venta> ventas) {
        return ventas.stream().map(VentaMapper::domainToDTO).collect(Collectors.toList());
    }

    public static List<venta> dTOToDomainList(List<VentaDTO> ventasDTO) {
        return ventasDTO.stream().map(VentaMapper::dTOToDomain).collect(Collectors.toList());
    }
}
