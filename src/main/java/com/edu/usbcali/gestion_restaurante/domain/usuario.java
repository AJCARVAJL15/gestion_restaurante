package com.edu.usbcali.gestion_restaurante.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class usuario {
    @Id
    @Column(nullable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_usuario;

    @Column(nullable = false, name = "nombre_usuario",length = 50)
    private String nombre_usuario;

    @Column(nullable = false, name = "contraseña",length = 255)
    private String contraseña_usuario;

    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false, referencedColumnName = "id_empleado")
    private empleado empleado;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "rol", nullable = false)
    private Rol rol;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "estado", nullable = false)
    private Estado estado;

    public enum Rol {
        ADMINISTRADOR, GERENTE, CAJERO
    }

    public enum Estado {
        ACTIVO, INACTIVO
    }


}
