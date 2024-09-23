package com.example.avancetf.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CountTecnicosPorCalificacionDTO {
    private String nombreTecnico;
    private String especialidad;
    private Double calificacion;

}
