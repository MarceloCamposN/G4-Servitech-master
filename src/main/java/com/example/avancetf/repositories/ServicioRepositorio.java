package com.example.avancetf.repositories;

import com.example.avancetf.Entities.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicioRepositorio extends JpaRepository<Servicio, Long> {
    List<Servicio> findByEliminadoFalse();
}
