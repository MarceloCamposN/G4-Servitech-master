package com.example.avancetf.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Long id;
    private String nombres;
    private String apellidos;
    private String correo;
    private String password;
    private String usuario;
    private String direccion;
    private Boolean eliminado;
}
