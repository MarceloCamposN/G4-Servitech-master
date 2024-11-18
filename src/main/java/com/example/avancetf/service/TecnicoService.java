package com.example.avancetf.service;

import com.example.avancetf.Entities.Servicio;
import com.example.avancetf.Entities.Tecnico;
import com.example.avancetf.dtos.CountSolicitudServiciosDTO;

import java.util.List;


public interface TecnicoService {
    public Tecnico insertarTecnico(Tecnico tecnico);
    public void eliminarTecnico(Long id);
    public Tecnico modificarTecnico(Tecnico tecnico);
    public List<Tecnico> listarTecnicos();
    public List<CountSolicitudServiciosDTO> listarSolicitudServicios();
    public Tecnico buscarPorId(Long id);
    Long buscarIdPorUsuarioId(Long usuarioId);
}
