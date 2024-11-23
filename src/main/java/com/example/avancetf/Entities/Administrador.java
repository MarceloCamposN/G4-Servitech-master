package com.example.avancetf.Entities;

import com.example.avancetf.Security.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Table(name = "administrador")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nivelAcceso;
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;

}