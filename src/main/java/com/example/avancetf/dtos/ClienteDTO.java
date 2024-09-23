package com.example.avancetf.dtos;

import com.example.avancetf.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ClienteDTO {

    private Long id;
    private String historialServicios;
    private User usuario;


}