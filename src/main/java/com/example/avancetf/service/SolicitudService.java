package com.example.avancetf.service;

import com.example.avancetf.Entities.SolicitudServicio;
import com.example.avancetf.dtos.CountNroSolicitudesSumMontoDTO;
import com.example.avancetf.dtos.ServicioPorEstadoDTO;

import java.time.LocalDate;
import java.util.List;

public interface SolicitudService {

    public SolicitudServicio insertarSolicitud(SolicitudServicio solicitud);
    public void eliminarSolicitud(Long id);
    public SolicitudServicio modificarSolicitud(SolicitudServicio solicitudServicio);
    public List<SolicitudServicio> listarSolicitudes();
    public void cancelarSolicitud(Long id);
    public List<SolicitudServicio> findByEstadoAndServicioTecnicoId(String estado, Long servicioTecnicoId);
    public List<SolicitudServicio> findByClienteId(Long id);
    public List<ServicioPorEstadoDTO> filtrarServiciosPorEstado(String estado, Long idCliente);
    public List<CountNroSolicitudesSumMontoDTO>MostrarServiciosDescendentementePorCantidadMontoTotalEntreFechas(LocalDate fechaInicio, LocalDate fechaFin);
    public List<CountNroSolicitudesSumMontoDTO>MostrarServiciosAscendentementePorCantidadMontoTotalEntreFechas(LocalDate fechaInicio, LocalDate fechaFin);
}
