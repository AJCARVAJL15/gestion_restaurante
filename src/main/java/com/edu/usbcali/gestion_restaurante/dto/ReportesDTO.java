package com.edu.usbcali.gestion_restaurante.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportesDTO {
    private Integer idReporte;
    private LocalDateTime fechaGeneracionReporte;
    private String rutaArchivoReporte;
    private Integer idSede;        // Referencia a la sede
    private String tipoReporte;    // Campo de tipo enumerado Reporte
}
