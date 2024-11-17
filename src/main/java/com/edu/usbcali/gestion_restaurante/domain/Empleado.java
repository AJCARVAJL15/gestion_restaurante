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
@Table(name = "empleados")
public class Empleado {
    @Id
    @Column(nullable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_empleado;

    @Column(nullable = false, name = "nombre",length = 100)
    private String nombreEmpleado;

    @Column(nullable = false, name = "apellido",length = 100)
    private String apellidoEmpleado;

    @Column(nullable = false, name = "fecha_contratacion")
    private LocalDateTime fecha_contratacion;

    @Column(nullable = false, name = "salario")
    private BigDecimal salario_empleado;

    @ManyToOne
    @JoinColumn(name = "id_sede", nullable = false, referencedColumnName = "id_sede")
    private Sede sede;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "cargo")
    private Cargo cargo;

    public enum Cargo {
       Cajero,Administrador,Cocinero,Mesero,Gerente
    }

}
