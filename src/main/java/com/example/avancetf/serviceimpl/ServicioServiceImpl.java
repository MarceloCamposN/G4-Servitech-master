package com.example.avancetf.serviceimpl;

import com.example.avancetf.Entities.Servicio;
import com.example.avancetf.service.ServicioService;
import com.example.avancetf.repositories.ServicioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    private ServicioRepositorio servicioRepositorio;

    @Transactional
    @Override
    public Servicio insertarServicio(Servicio servicio) {
        return servicioRepositorio.save(servicio);
    }

    @Override
    public void eliminarServicio(Long id) {
        if(servicioRepositorio.existsById(id)) {
            servicioRepositorio.deleteById(id);
        }
    }

    @Override
    public void eliminarLogicoServicio(Long id) {
        Servicio servicio = servicioRepositorio.findById(id).get();
        servicio.setEliminado(true);
        servicioRepositorio.save(servicio);
    }

    @Override
    public Servicio modificarServicio(Servicio servicio) {
        if(servicioRepositorio.existsById(servicio.getId())){
            return servicioRepositorio.save(servicio);
        }
        return null;
    }

    @Override
    public List<Servicio> listarServicios(String estado) {
        return servicioRepositorio.findByEliminadoFalseAndEstado(estado);
    }

    @Override
    public Servicio buscarPorId(Long id) {
        if(servicioRepositorio.findById(id).isPresent()){
            return servicioRepositorio.findById(id).get();
        }
        return null;
    }

    @Override
    public List<Servicio> findByTecnicoAndEliminadoFalse(Long id) {
        return servicioRepositorio.findByTecnicoIdAndEliminadoFalse(id);
    }


}
