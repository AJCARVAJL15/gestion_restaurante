package com.edu.usbcali.gestion_restaurante.mapper;

import com.edu.usbcali.gestion_restaurante.domain.cierrecaja;
import com.edu.usbcali.gestion_restaurante.dto.CierrecajaDTO;

import java.util.List;

public class CierrecajaMapper {

    public static CierrecajaDTO domainToDTO(cierrecaja cierre) {
        return CierrecajaDTO.builder()
                .idCierre(cierre.getId_cierre())
                .idSede(cierre.getSede().getId_sede()) // Asegúrate de que 'sede' no sea null
                .idEmpleado(cierre.getEmpleado().getId_empleado()) // Asegúrate de que 'empleado' no sea null
                .fechaCierre(cierre.getFecha_cierre())
                .totalEfectivo(cierre.getTotal_efectivo())
                .totalTarjeta(cierre.getTotal_tarjeta())
                .totalTransferencia(cierre.getTotal_transferencia())
                .totalCierre(cierre.getTotal_cierre())
                .build();
    }

    public static cierrecaja dTOToDomain(CierrecajaDTO cierreDTO) {
        return cierrecaja.builder()
                .id_cierre(cierreDTO.getIdCierre())
                .fecha_cierre(cierreDTO.getFechaCierre())
                .total_efectivo(cierreDTO.getTotalEfectivo())
                .total_tarjeta(cierreDTO.getTotalTarjeta())
                .total_transferencia(cierreDTO.getTotalTransferencia())
                .total_cierre(cierreDTO.getTotalCierre())
                .build();
    }

    public static List<CierrecajaDTO> domainToDTOList(List<cierrecaja> cierres) {
        return cierres.stream().map(CierrecajaMapper::domainToDTO).toList();
    }

    public static List<cierrecaja> dTOToDomainList(List<CierrecajaDTO> cierresDTO) {
        return cierresDTO.stream().map(CierrecajaMapper::dTOToDomain).toList();
    }
}
