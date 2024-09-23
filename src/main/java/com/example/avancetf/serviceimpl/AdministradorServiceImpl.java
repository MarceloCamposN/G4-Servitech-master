package com.example.avancetf.serviceimpl;

import com.example.avancetf.Entities.Administrador;
import com.example.avancetf.service.AdministradorService;
import com.example.avancetf.repositories.AdministradorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdministradorServiceImpl implements AdministradorService {
    @Autowired
    private AdministradorRepositorio administradorRepositorio;

    @Transactional
    public Administrador insertarAdministrador(Administrador administrador) {
        return administradorRepositorio.save(administrador);
    }
    @Override
    public void eliminarAdministrador(Long id) {
        if(administradorRepositorio.existsById(id)) {
            administradorRepositorio.deleteById(id);
        }
    }
    @Override
    public Administrador modificarAdministrador(Administrador administrador) {
        if(administradorRepositorio.existsById(administrador.getId())){
            return administradorRepositorio.save(administrador);
        }
        return null;
    }
    @Override
    public List<Administrador> listarAdministradores() {
        return administradorRepositorio.findByUsuarioEliminadoFalse();
    }

}
