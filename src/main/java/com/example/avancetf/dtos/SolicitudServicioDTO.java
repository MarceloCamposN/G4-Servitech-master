package com.example.avancetf.dtos;

import com.example.avancetf.Entities.Cliente;
import com.example.avancetf.Entities.Pago;
import com.example.avancetf.Entities.Servicio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SolicitudServicioDTO {
    private Long id;
    private LocalDate fechaSolicitud;
    private String descripcionProblema;
    private String estado;
    private Boolean eliminado;
    private Servicio servicio;
    private Cliente cliente;
    private Pago pago;
}
