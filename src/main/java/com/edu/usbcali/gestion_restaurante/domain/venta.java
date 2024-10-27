package com.edu.usbcali.gestion_restaurante.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "venta")

public class venta {
    @Id
    @Column(nullable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_venta;

    @ManyToOne
    @JoinColumn(name = "id_sede", nullable = false, referencedColumnName = "id_sede")
    private sede sede;

    @ManyToOne
    @JoinColumn(name = "id_cajero", nullable = false, referencedColumnName = "id_empleado")
    private empleado empleado;

    @Column(nullable = false, name = "fecha")
    private LocalDateTime fecha_venta;

    @Column(nullable = false, name = "total")
    private BigDecimal total_venta;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "metodo_pago")
    private MetodoPago metodo_pago;

   
    public enum MetodoPago {
        EFECTIVO, TARJETA, TRANSFERENCIA
    }
}
