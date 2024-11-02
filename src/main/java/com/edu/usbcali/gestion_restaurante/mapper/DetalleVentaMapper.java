package com.edu.usbcali.gestion_restaurante.mapper;

import com.edu.usbcali.gestion_restaurante.domain.detalleventa;
import com.edu.usbcali.gestion_restaurante.dto.DetalleVentaDTO;

import java.util.List;
import java.util.stream.Collectors;

public class DetalleVentaMapper {

    public static DetalleVentaDTO domainToDTO(detalleventa detalle) {
        return DetalleVentaDTO.builder()
                .idDetalle(detalle.getId_detalle())
                .idVenta(detalle.getVenta().getId_venta()) // Asegúrate de que 'venta' no sea null
                .idProducto(detalle.getProducto().getId_producto()) // Asegúrate de que 'producto' no sea null
                .cantidad(detalle.getCantidad())
                .precioUnitario(detalle.getPrecio_unitario())
                .subtotal(detalle.getSubtotal())
                .build();
    }

    public static detalleventa dTOToDomain(DetalleVentaDTO detalleDTO) {
        return detalleventa.builder()
                .id_detalle(detalleDTO.getIdDetalle())
                .cantidad(detalleDTO.getCantidad())
                .precio_unitario(detalleDTO.getPrecioUnitario())
                .subtotal(detalleDTO.getSubtotal())
                .build();
    }

    public static List<DetalleVentaDTO> domainToDTOList(List<detalleventa> detalles) {
        return detalles.stream().map(DetalleVentaMapper::domainToDTO).collect(Collectors.toList());
    }

    public static List<detalleventa> dTOToDomainList(List<DetalleVentaDTO> detallesDTO) {
        return detallesDTO.stream().map(DetalleVentaMapper::dTOToDomain).collect(Collectors.toList());
    }
}
