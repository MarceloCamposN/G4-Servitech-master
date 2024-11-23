package com.example.avancetf.repositories;

import com.example.avancetf.Entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    List<Cliente> findByUsuarioEliminadoFalse();
    @Query("SELECT t.id FROM Cliente t WHERE t.usuario.id = :usuarioId")
    Long findIdByUsuarioId(@Param("usuarioId") Long usuarioId);
}
