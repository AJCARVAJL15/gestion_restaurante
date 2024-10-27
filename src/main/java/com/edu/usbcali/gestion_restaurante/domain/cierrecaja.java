package com.edu.usbcali.gestion_restaurante.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cierrescaja")
public class cierrecaja {
    @Id
    @Column(nullable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_cierre;

    @ManyToOne
    @JoinColumn(name = "id_sede", nullable = false, referencedColumnName = "id_sede")
    private sede sede;

    @Column(name = "fecha")
    private LocalDateTime fecha_cierre;

    @Column(name = "total_efectivo")
    private BigDecimal total_efectivo;

    @Column(name = "total_tarjeta")
    private BigDecimal total_tarjeta;

    @Column(name = "total_transferencia")
    private BigDecimal total_transferencia;

    @Column(name = "total")
    private BigDecimal total_cierre;

    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false, referencedColumnName = "id_empleado")
    private empleado empleado;

}
