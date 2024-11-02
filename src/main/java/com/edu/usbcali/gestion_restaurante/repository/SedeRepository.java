package com.edu.usbcali.gestion_restaurante.repository;

import com.edu.usbcali.gestion_restaurante.domain.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SedeRepository extends JpaRepository<Sede, Integer> {
}
