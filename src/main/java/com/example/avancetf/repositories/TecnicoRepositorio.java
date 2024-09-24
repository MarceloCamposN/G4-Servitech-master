package com.example.avancetf.repositories;

import com.example.avancetf.Entities.Tecnico;
import com.example.avancetf.dtos.CountSolicitudServiciosDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TecnicoRepositorio extends JpaRepository<Tecnico, Long> {
    List<Tecnico> findByUsuarioEliminadoFalse();
    @Query("select new com.example.avancetf.dtos.CountSolicitudServiciosDTO(ss.servicio.tecnico.usuario.nombres, ss.servicio.tecnico.usuario.apellidos, count(ss.servicio.tecnico)) from SolicitudServicio ss group by ss.servicio.tecnico.usuario.nombres, ss.servicio.tecnico.usuario.apellidos order by count(ss.servicio.tecnico) desc")
    List<CountSolicitudServiciosDTO> listarSolicitudServicios();
}
