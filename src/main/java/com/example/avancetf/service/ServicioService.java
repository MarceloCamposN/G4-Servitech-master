package com.example.avancetf.service;
import com.example.avancetf.Entities.Servicio;

import java.util.List;


public interface ServicioService {
    public Servicio insertarServicio(Servicio servicio);
    public void eliminarServicio(Long id);
    public void eliminarLogicoServicio(Long id);
    public Servicio modificarServicio(Servicio servicio);
    public List<Servicio> listarServicios(String estado);
    public Servicio buscarPorId(Long id);
    public List<Servicio> findByTecnicoAndEliminadoFalse(Long id);
}
