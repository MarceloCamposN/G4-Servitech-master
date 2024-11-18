package com.example.avancetf.service;

import com.example.avancetf.Entities.SolicitudServicio;
import com.example.avancetf.Entities.Tecnico;
import com.example.avancetf.dtos.CountNroSolicitudesSumMontoDTO;
import com.example.avancetf.dtos.ServicioPorEstadoDTO;

import java.time.LocalDate;
import java.util.List;

public interface SolicitudService {

    public SolicitudServicio insertarSolicitud(SolicitudServicio solicitud);
    public void eliminarSolicitud(Long id);
    public SolicitudServicio modificarSolicitud(SolicitudServicio solicitudServicio);
    public List<SolicitudServicio> listarSolicitudes();
    public void TerminarSolicitud(Long id);
    public void procesarSolicitud(Long id);
    public void cancelarSolicitud(Long id);
    public SolicitudServicio buscarPorId(Long id);
    public List<SolicitudServicio> findByEstadoAndServicioId(String estado, Long servicioId);
    public List<SolicitudServicio> findByServicioTecnicoId(Long id);
    public List<SolicitudServicio> findByClienteIdAndEstado(Long id, String Estado);
    public List<ServicioPorEstadoDTO> filtrarServiciosPorEstado(String estado, Long idCliente);
    public List<CountNroSolicitudesSumMontoDTO>MostrarServiciosDescendentementePorCantidadMontoTotalEntreFechas(LocalDate fechaInicio, LocalDate fechaFin);
    public List<CountNroSolicitudesSumMontoDTO>MostrarServiciosAscendentementePorCantidadMontoTotalEntreFechas(LocalDate fechaInicio, LocalDate fechaFin);
}
