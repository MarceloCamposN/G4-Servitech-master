package com.example.avancetf.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@Table(name = "tecnico")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String especialidad;
    private String descripcion;
    private String horario;
    private Boolean eliminado;
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;

}
