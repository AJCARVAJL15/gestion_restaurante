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
@Table(name = "sedes")
public class sede { // Nombre de la clase en mayúscula
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_sede;

    @Column(nullable = false, name = "nombre", length = 100)
    private String nombre_sede;

    @Column(nullable = false, name = "ubicacion", length = 100)
    private String direccion_sede;

    @Column(nullable = false, name = "telefono_contacto", length = 20)
    private String telefono_sede;

    @Column(nullable = false, name = "fecha_apertura")
    private LocalDateTime fecha_apertura;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "tipo")
    private TipoSede tipo;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "estado")
    private Estado estado;

    public enum TipoSede {
        PROPIA, FRANQUICIA
    }

    public enum Estado {
        OPERATIVA, CERRADA, EN_MANTENIMIENTO
    }
}
