package com.example.avancetf.serviceimpl;

import com.example.avancetf.Entities.Tecnico;
import com.example.avancetf.dtos.CountSolicitudServiciosDTO;
import com.example.avancetf.service.TecnicoService;
import com.example.avancetf.repositories.TecnicoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TecnicoServiceImpl implements TecnicoService {
    @Autowired
    private TecnicoRepositorio tecnicoRepositorio;
    @Transactional
    @Override
    public Tecnico insertarTecnico(Tecnico tecnico) {
        return tecnicoRepositorio.save(tecnico);
    }
    @Override
    public void eliminarTecnico(Long id) {
        if(tecnicoRepositorio.existsById(id)) {
            tecnicoRepositorio.deleteById(id);
        }
    }
    @Override
    public Tecnico modificarTecnico(Tecnico tecnico) {
        if(tecnicoRepositorio.existsById(tecnico.getId())){
            return tecnicoRepositorio.save(tecnico);
        }
        return null;
    }
    @Override
    public List<Tecnico> listarTecnicos() {
        return tecnicoRepositorio.findByUsuarioEliminadoFalse();
    }
    @Override
    public List<CountSolicitudServiciosDTO>listarSolicitudServicios(){
        return tecnicoRepositorio.listarSolicitudServicios();
    }

    @Override
    public Tecnico buscarPorId(Long id) {
        if(tecnicoRepositorio.findById(id).isPresent()){
            return tecnicoRepositorio.findById(id).get();
        }
        return null;
    }
    @Override
    public Long buscarIdPorUsuarioId(Long usuarioId) {
        return tecnicoRepositorio.findIdByUsuarioId(usuarioId);
    }
}