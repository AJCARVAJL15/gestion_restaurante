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
@Table(name = "detalleventa")


public class detalleventa {
    @Id
    @Column(nullable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_detalle;

    @ManyToOne
    @JoinColumn(name = "id_venta", nullable = false, referencedColumnName = "id_venta")
    private venta venta;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false, referencedColumnName = "id_producto")
    private Producto producto;

    @Column(nullable = false)   
    private Integer cantidad;

    @Column(nullable = false)   
    private BigDecimal precio_unitario;

    @Column(nullable = false)   
    private BigDecimal subtotal;
    
}
