package com.edu.usbcali.gestion_restaurante.repository;

import com.edu.usbcali.gestion_restaurante.domain.Reportes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportesRepository extends JpaRepository<Reportes, Integer> {
}
