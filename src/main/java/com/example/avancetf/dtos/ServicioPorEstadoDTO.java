package com.example.avancetf.dtos;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ServicioPorEstadoDTO {

    private String descripcion;
    private String tipo;
    private Double costo;
    private LocalDate fechaServicio;
}
