package com.example.avancetf.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountSolicitudServiciosDTO {
    private String nombre; // nombres
    private String apellido; //apellidos
    private Long solicitudes; //numero de solicitudes
}
