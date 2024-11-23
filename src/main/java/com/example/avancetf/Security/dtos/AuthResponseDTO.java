package com.example.avancetf.Security.dtos;

import java.util.Set;

@lombok.Data
public class AuthResponseDTO {
    private String jwt;
    private Set<String> roles;
    private Long idTecnico;
    private Long idCliente;
}
