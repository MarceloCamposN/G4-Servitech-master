package com.example.avancetf.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountNroSolicitudesSumMontoDTO {
    private String nombre; //nombre del servicio
    private Long cantidad; //cantidad de servicios
    private Double monto; //monto total recaudado de todos los servicios
}
