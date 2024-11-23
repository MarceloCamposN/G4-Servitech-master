package com.example.avancetf.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "servicio")
@AllArgsConstructor
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    private String descripcion;
    private String tipo;
    private Double costo;
    private String estado;
    private Boolean eliminado;
    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

}
