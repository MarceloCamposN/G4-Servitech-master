package com.example.avancetf.repositories;

import com.example.avancetf.Entities.Administrador;
import com.example.avancetf.Entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdministradorRepositorio extends JpaRepository<Administrador, Long> {
    List<Administrador> findByUsuarioEliminadoFalse();

}
