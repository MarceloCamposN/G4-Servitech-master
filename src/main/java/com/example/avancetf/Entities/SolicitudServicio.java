package com.example.avancetf.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@Table(name = "solicitudServicio")
@AllArgsConstructor

public class SolicitudServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true) // un compañero agregó un query sobre fecha ayer profe ahora lo reviso
    private LocalDate fechaSolicitud;
    private String descripcionProblema;
    private Double precioFinal;
    private String estado;
    private Boolean eliminado;
    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @OneToOne
    @JoinColumn(name = "pago_id")
    private Pago pago;
}
