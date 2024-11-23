package com.example.avancetf.dtos;

import com.example.avancetf.Entities.Cliente;
import com.example.avancetf.Entities.Servicio;
import com.example.avancetf.Entities.Tecnico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValoracionDTO {
    private Long id;
    private String comentario;
    private String tipo;
    private Double calificacion;
    private String fecha;
    private Cliente cliente;
    private Tecnico tecnico;

}
