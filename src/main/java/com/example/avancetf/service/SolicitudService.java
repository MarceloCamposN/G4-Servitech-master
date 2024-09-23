package com.example.avancetf.service;

import com.example.avancetf.Entities.SolicitudServicio;

import java.util.List;

public interface SolicitudService {

    public SolicitudServicio insertarSolicitud(SolicitudServicio solicitud);
    public void eliminarSolicitud(Long id);
    public SolicitudServicio modificarSolicitud(SolicitudServicio solicitudServicio);
    public List<SolicitudServicio> listarSolicitudes();
    public void cancelarSolicitud(Long id);
    public List<SolicitudServicio> findByEstadoAndServicioTecnicoId(String estado, Long servicioTecnicoId);
    public List<SolicitudServicio> findByClienteId(Long id);
}
