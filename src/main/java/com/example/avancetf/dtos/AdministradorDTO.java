package com.example.avancetf.dtos;

import com.example.avancetf.Security.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdministradorDTO {
    private Long id;
    private String nivelAcceso;
    private User usuario;
}
