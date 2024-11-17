package com.edu.usbcali.gestion_restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.usbcali.gestion_restaurante.domain.Sede;

@Repository
public interface SedeRepository extends JpaRepository<Sede, Integer> {
}
