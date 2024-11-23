package com.example.avancetf.dtos;

import com.example.avancetf.Security.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ClienteDTO {

    private Long id;
    private LocalDate fechaCreacion;
    private User usuario;


}