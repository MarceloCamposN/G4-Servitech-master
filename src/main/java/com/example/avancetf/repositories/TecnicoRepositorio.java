package com.example.avancetf.repositories;

import com.example.avancetf.Entities.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TecnicoRepositorio extends JpaRepository<Tecnico, Long> {
    List<Tecnico> findByUsuarioEliminadoFalse();
}
