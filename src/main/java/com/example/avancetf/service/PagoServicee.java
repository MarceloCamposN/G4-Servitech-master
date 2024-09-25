package com.example.avancetf.service;

import com.example.avancetf.Entities.Pago;

import java.util.List;

public interface PagoServicee {
    public Pago insertarPago(Pago pago);
    public void eliminarPago(Long id);
    public Pago modificarPago(Pago pago);
    public List<Pago> listarPagos();
}
