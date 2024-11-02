package com.edu.usbcali.gestion_restaurante.repository;

import com.edu.usbcali.gestion_restaurante.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
