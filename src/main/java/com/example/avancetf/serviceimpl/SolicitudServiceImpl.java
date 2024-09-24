package com.example.avancetf.serviceimpl;

import com.example.avancetf.Entities.SolicitudServicio;
import com.example.avancetf.dtos.CountNroSolicitudesSumMontoDTO;
import com.example.avancetf.dtos.ServicioPorEstadoDTO;
import com.example.avancetf.dtos.SolicitudServicioDTO;
import com.example.avancetf.service.SolicitudService;
import com.example.avancetf.repositories.SolicitudRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class SolicitudServiceImpl implements SolicitudService {
    @Autowired
    private SolicitudRepositorio solicitudRepositorio;
    @Transactional
    @Override
    public SolicitudServicio insertarSolicitud(SolicitudServicio solicitud) {
        return solicitudRepositorio.save(solicitud);
    }

    @Override
    public void eliminarSolicitud(Long id) {
        if(solicitudRepositorio.existsById(id)) {
            solicitudRepositorio.deleteById(id);
        }
    }

    @Override
    public SolicitudServicio modificarSolicitud(SolicitudServicio solicitudServicio) {
        return solicitudRepositorio.save(solicitudServicio);
    }

    @Override
    public List<SolicitudServicio> listarSolicitudes() {
        return solicitudRepositorio.findAll();
    }

    @Override
    public void cancelarSolicitud(Long id) {
        SolicitudServicio solicitudServicio = solicitudRepositorio.findById(id).get();
        if(!solicitudServicio.getEstado().equals("En Proceso"))
        {
            throw new IllegalStateException("Solo se pueden cancelar solicitudes que están en proceso.");
        }
        solicitudServicio.setEstado("Cancelado");
        solicitudRepositorio.save(solicitudServicio);
    }

    @Override
    public List<SolicitudServicio> findByEstadoAndServicioTecnicoId(String estado, Long servicioTecnicoId) {
        return solicitudRepositorio.findByEstadoAndServicioTecnicoId(estado, servicioTecnicoId);
    }

    @Override
    public List<SolicitudServicio> findByClienteId(Long id) {
        
        return solicitudRepositorio.findByClienteId(id);
    }
    @Override
    public List<ServicioPorEstadoDTO> filtrarServiciosPorEstado(String estado, Long idCliente){
        return solicitudRepositorio.filtrarServiciosPorEstado(estado, idCliente);
    }
    @Override
    public List<CountNroSolicitudesSumMontoDTO> MostrarServiciosDescendentementePorCantidadMontoTotalEntreFechas(LocalDate fechaInicio, LocalDate fechaFin){
        return solicitudRepositorio.MostrarServiciosDescendentementePorCantidadMontoTotalEntreFechas(fechaInicio, fechaFin);
    }
    @Override
    public List<CountNroSolicitudesSumMontoDTO> MostrarServiciosAscendentementePorCantidadMontoTotalEntreFechas(LocalDate fechaInicio, LocalDate fechaFin){
        return solicitudRepositorio.MostrarServiciosAscendentementePorCantidadMontoTotalEntreFechas(fechaInicio, fechaFin);
    }
}
