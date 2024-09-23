package com.example.avancetf.repositories;

import com.example.avancetf.Entities.SolicitudServicio;
import com.example.avancetf.dtos.ServicioPorEstadoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SolicitudRepositorio extends JpaRepository<SolicitudServicio, Long> {
    //Encuentra todos los servicios de un cliente por estado(finalizado,actico o espera)
    List<SolicitudServicio> findByEstadoAndServicioTecnicoId(String estado, Long servicioTecnicoId);
    List<SolicitudServicio> findByClienteId(Long id);
    @Query("select new com.example.avancetf.dtos.ServicioPorEstadoDTO(s.descripcion, s.tipo, s.costo, ss.fechaSolicitud) from SolicitudServicio ss join ss.servicio s join ss.cliente c where ss.estado = :estado and c.id = :idCliente")
    List<ServicioPorEstadoDTO> filtrarServiciosPorEstado(@Param("estado") String estado, @Param("idCliente") Long idCliente);
}
