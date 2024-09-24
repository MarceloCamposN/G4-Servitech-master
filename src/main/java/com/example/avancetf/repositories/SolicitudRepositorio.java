package com.example.avancetf.repositories;

import com.example.avancetf.Entities.SolicitudServicio;
import com.example.avancetf.dtos.CountNroSolicitudesSumMontoDTO;
import com.example.avancetf.dtos.ServicioPorEstadoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

public interface SolicitudRepositorio extends JpaRepository<SolicitudServicio, Long> {
    //Encuentra todos los servicios de un cliente por estado(finalizado,actico o espera)
    List<SolicitudServicio> findByEstadoAndServicioTecnicoId(String estado, Long servicioTecnicoId);
    List<SolicitudServicio> findByClienteId(Long id);
    @Query("select new com.example.avancetf.dtos.ServicioPorEstadoDTO(ss.servicio.descripcion, ss.servicio.tipo, ss.servicio.costo, ss.fechaSolicitud) from SolicitudServicio ss where ss.estado = :estado and ss.cliente.id = :idCliente")
    List<ServicioPorEstadoDTO> filtrarServiciosPorEstado(@Param("estado") String estado, @Param("idCliente") Long idCliente);

    @Query("select new com.example.avancetf.dtos.CountNroSolicitudesSumMontoDTO(ss.servicio.nombre, count(ss), sum(ss.servicio.costo)) from SolicitudServicio ss where ss.fechaSolicitud between :fechaInicio and :fechaFin group by ss.servicio.nombre order by sum(ss.servicio.costo)desc ")
    List<CountNroSolicitudesSumMontoDTO> MostrarServiciosDescendentementePorCantidadMontoTotalEntreFechas(@PathVariable("fechaInicio")LocalDate fechaInicio, @PathVariable("fechaFin")LocalDate fechaFin);
    @Query("select new com.example.avancetf.dtos.CountNroSolicitudesSumMontoDTO(ss.servicio.nombre, count(ss), sum(ss.servicio.costo)) from SolicitudServicio ss where ss.fechaSolicitud between :fechaInicio and :fechaFin group by ss.servicio.nombre order by sum(ss.servicio.costo)asc ")
    List<CountNroSolicitudesSumMontoDTO> MostrarServiciosAscendentementePorCantidadMontoTotalEntreFechas(@PathVariable("fechaInicio")LocalDate fechaInicio, @PathVariable("fechaFin")LocalDate fechaFin);
}
