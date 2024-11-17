package com.edu.usbcali.gestion_restaurante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edu.usbcali.gestion_restaurante.domain.Empleado;
import com.edu.usbcali.gestion_restaurante.domain.Sede;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    Empleado findByNombreEmpleadoAndApellidoEmpleadoAndSede(String nombre_empleado, String apellido_empleado, Sede sede);
    @Query(value = "SELECT * FROM empleados e WHERE e.id_sede = :idSede", nativeQuery = true)
    List<Empleado> findById_sede(@Param("idSede") Integer idSede);
}
