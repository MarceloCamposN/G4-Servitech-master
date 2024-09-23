package com.example.avancetf.dtos;

import com.example.avancetf.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TecnicoDTO {

    private Long id;
    private String especialidad;
    private String descripcion;
    private String horario;
    private Boolean eliminado;
    private User usuario;
}
