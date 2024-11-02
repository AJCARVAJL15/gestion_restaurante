package com.edu.usbcali.gestion_restaurante.mapper;

import com.edu.usbcali.gestion_restaurante.domain.reportes;
import com.edu.usbcali.gestion_restaurante.domain.sede; // Importa la clase sede
import com.edu.usbcali.gestion_restaurante.dto.ReportesDTO;
import java.util.List;
import java.util.stream.Collectors;

public class ReportesMapper {

    public static ReportesDTO domainToDTO(reportes reporte) {
        return ReportesDTO.builder()
                .idReporte(reporte.getId_reporte())
                .fechaGeneracionReporte(reporte.getFecha_generacion_reporte())
                .rutaArchivoReporte(reporte.getRuta_archivo_reporte())
                .idSede(reporte.getSede() != null ? reporte.getSede().getId_sede() : null) // Asigna el ID de la sede
                .tipoReporte(reporte.getTipo_reporte() != null ? reporte.getTipo_reporte().name() : null) // Convierte el enum a String
                .build();
    }

    public static reportes dTOToDomain(ReportesDTO reportesDTO) {
        reportes reporte = reportes.builder()
                .id_reporte(reportesDTO.getIdReporte())
                .fecha_generacion_reporte(reportesDTO.getFechaGeneracionReporte())
                .ruta_archivo_reporte(reportesDTO.getRutaArchivoReporte())
                .build();

        // Asignar la sede
        if (reportesDTO.getIdSede() != null) {
            sede sedeInstance = new sede(); // Inicializa la variable sedeInstance
            sedeInstance.setId_sede(reportesDTO.getIdSede()); // Asigna el ID de la sede
            reporte.setSede(sedeInstance); // Establece la sede en el reporte
        }

        // Asignar el tipo de reporte
        if (reportesDTO.getTipoReporte() != null) {
            reporte.setTipo_reporte(reportes.Reporte.valueOf(reportesDTO.getTipoReporte())); // Convierte de String a enum
        }

        return reporte;
    }

    public static List<ReportesDTO> domainToDTOList(List<reportes> reportesList) {
        return reportesList.stream().map(ReportesMapper::domainToDTO).collect(Collectors.toList());
    }

    public static List<reportes> dTOToDomainList(List<ReportesDTO> reportesDTOList) {
        return reportesDTOList.stream().map(ReportesMapper::dTOToDomain).collect(Collectors.toList());
    }
}
