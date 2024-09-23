package com.example.avancetf.service;
import com.example.avancetf.Entities.Servicio;

import java.util.List;


public interface ServicioService {
    public Servicio insertarServicio(Servicio servicio);
    public void eliminarServicio(Long id);
    public Servicio modificarServicio(Servicio servicio);
    public List<Servicio> listarServicios();

}
