package com.example.avancetf.repositories;

import com.example.avancetf.Entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    List<Cliente> findByUsuarioEliminadoFalse();

}
