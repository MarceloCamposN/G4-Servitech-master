package com.example.avancetf.service;

import com.example.avancetf.Entities.Tecnico;

import java.util.List;


public interface TecnicoService {
    public Tecnico insertarTecnico(Tecnico tecnico);
    public void eliminarTecnico(Long id);
    public Tecnico modificarTecnico(Tecnico tecnico);
    public List<Tecnico> listarTecnicos();
}
