package com.example.avancetf.serviceimpl;

import com.example.avancetf.Entities.Valoracion;
import com.example.avancetf.dtos.CountTecnicosPorCalificacionDTO;
import com.example.avancetf.service.ValoracionService;
import com.example.avancetf.repositories.ValoracionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ValoracionServiceImpl implements ValoracionService {
    @Autowired
    private ValoracionRepositorio valoracionRepositorio;
    @Transactional
    @Override
    public Valoracion insertarValoracion(Valoracion valoracion) {
        return valoracionRepositorio.save(valoracion);
    }

    @Override
    public void eliminarValoracion(Long id) {
        if(valoracionRepositorio.existsById(id)) {
            valoracionRepositorio.deleteById(id);
        }
    }

    @Override
    public Valoracion modificarValoracion(Valoracion valoracion) {
        if(valoracionRepositorio.existsById(valoracion.getId())){
            return valoracionRepositorio.save(valoracion);
        }
        return null;
    }

    @Override
    public List<Valoracion> listarValoracions() {
        return valoracionRepositorio.findAll();
    }

    @Override
    public List<Valoracion> findByTecnicoId(Long id) {
        return valoracionRepositorio.findByTecnicoId(id);
    }

    @Override
    public List<CountTecnicosPorCalificacionDTO> filtrarTecnicosPorCalificacion(Double calificacion) {
        return valoracionRepositorio.filtrarTecnicosPorCalificacion(calificacion);
    }

}
