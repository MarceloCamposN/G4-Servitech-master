package com.example.avancetf.service;

import com.example.avancetf.Entities.Valoracion;
import com.example.avancetf.dtos.CountTecnicosPorCalificacionDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ValoracionService {
    public Valoracion insertarValoracion(Valoracion valoracion);
    public void eliminarValoracion(Long id);
    public Valoracion modificarValoracion(Valoracion valoracion);
    public List<Valoracion> listarValoracions();
    public List<Valoracion> findByTecnicoId(Long id);
    public List<Valoracion> findByClienteId(Long id);
    public List<CountTecnicosPorCalificacionDTO> filtrarTecnicosPorCalificacion(Double calificacion);

    Valoracion buscarPorId(Long id);
}
