package com.edu.usbcali.gestion_restaurante.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productos")
public class Producto{

    @Id
    @Column(nullable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_producto;

    @Column(length=100,nullable=false)
    private String nombre;

    @Column(columnDefinition = "text")
    private String descripcion;

    @Column(nullable = false)
    private BigDecimal precio;

    @Column(length = 50)
    private String categoria;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "estado_producto")
    private EstadoProducto estado;

   
    public enum EstadoProducto {
        DISPONIBLE,
        NO_DISPONIBLE
    }

 
}