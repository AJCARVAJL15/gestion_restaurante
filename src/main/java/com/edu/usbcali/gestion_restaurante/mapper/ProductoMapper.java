package com.edu.usbcali.gestion_restaurante.mapper;

import com.edu.usbcali.gestion_restaurante.domain.Producto;
import com.edu.usbcali.gestion_restaurante.dto.ProductoDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ProductoMapper {

    public static ProductoDTO domainToDTO(Producto producto) {
        return ProductoDTO.builder()
                .idProducto(producto.getId_producto())
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .precio(producto.getPrecio())
                .categoria(producto.getCategoria())
                .estado(producto.getEstado() != null ? producto.getEstado().name() : null) // Convierte el enum a String
                .build();
    }

    public static Producto dTOToDomain(ProductoDTO productoDTO) {
        Producto producto = Producto.builder()
                .id_producto(productoDTO.getIdProducto())
                .nombre(productoDTO.getNombre())
                .descripcion(productoDTO.getDescripcion())
                .precio(productoDTO.getPrecio())
                .categoria(productoDTO.getCategoria())
                .build();
        
        // Asignar el estado
        if (productoDTO.getEstado() != null) {
            producto.setEstado(Producto.EstadoProducto.valueOf(productoDTO.getEstado())); // Convierte de String a enum
        }
        
        return producto;
    }

    public static List<ProductoDTO> domainToDTOList(List<Producto> productos) {
        return productos.stream().map(ProductoMapper::domainToDTO).collect(Collectors.toList());
    }

    public static List<Producto> dTOToDomainList(List<ProductoDTO> productosDTO) {
        return productosDTO.stream().map(ProductoMapper::dTOToDomain).collect(Collectors.toList());
    }
}
