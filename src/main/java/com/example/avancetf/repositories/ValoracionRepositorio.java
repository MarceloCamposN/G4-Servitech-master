package com.example.avancetf.repositories;

import com.example.avancetf.Entities.Valoracion;
import com.example.avancetf.dtos.CountTecnicosPorCalificacionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ValoracionRepositorio extends JpaRepository<Valoracion, Long> {
    List<Valoracion> findByTecnicoId(Long id);
    @Query("select new com.example.avancetf.dtos.CountTecnicosPorCalificacionDTO(v.tecnico.usuario.nombres, v.tecnico.descripcion, v.calificacion) " +
            "from Valoracion v where v.calificacion =:calificacion " +
            "group by v.tecnico.usuario.nombres, v.tecnico.descripcion, v.calificacion")
    List<CountTecnicosPorCalificacionDTO> filtrarTecnicosPorCalificacion(@Param("calificacion") Double calificacion);
    }
