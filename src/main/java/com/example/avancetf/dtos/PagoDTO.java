package com.example.avancetf.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class PagoDTO {
    private Long id;
    private String fecha;
    private String metodoPago;
}
