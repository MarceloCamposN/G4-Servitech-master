package com.example.avancetf.dtos;

import com.example.avancetf.Entities.Tecnico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicioDTO{

    private Long id;
    private String descripcion;
    private String tipo;
    private Double costo;
    private String estado;
    private Boolean eliminado;
    private Tecnico tecnico;
}
