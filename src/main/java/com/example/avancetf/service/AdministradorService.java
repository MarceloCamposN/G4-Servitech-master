package com.example.avancetf.service;

import com.example.avancetf.Entities.Administrador;

import java.util.List;

public interface AdministradorService {
    public Administrador insertarAdministrador(Administrador administrador);
    public void eliminarAdministrador(Long id);
    public Administrador modificarAdministrador(Administrador administrador);
    public List<Administrador> listarAdministradores();

}
