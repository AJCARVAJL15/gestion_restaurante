package com.edu.usbcali.gestion_restaurante.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reportes")
public class reportes {
    @Id
    @Column(nullable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_reporte;

    @Column(name = "fecha_generacion")
    private LocalDateTime fecha_generacion_reporte;

    @Column( name = "ruta_archivo",length = 255)
    private String ruta_archivo_reporte;

    @ManyToOne
    @JoinColumn(name = "id_sede", nullable = false, referencedColumnName = "id_sede")
    private sede sede;

     @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "tipo_reporte")
    private Reporte tipo_reporte;

    public enum Reporte {
        VENTAS, INVENTARIO, CIERRESDECAJA,CONTABILIDAD
    }
}
