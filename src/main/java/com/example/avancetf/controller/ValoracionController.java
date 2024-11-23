package com.example.avancetf.controller;

import com.example.avancetf.Entities.Servicio;
import com.example.avancetf.Entities.Valoracion;
import com.example.avancetf.dtos.CountTecnicosPorCalificacionDTO;
import com.example.avancetf.dtos.ServicioDTO;
import com.example.avancetf.dtos.ValoracionDTO;
import com.example.avancetf.service.ValoracionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:4200","http://18.219.237.192/"})
@RestController
@RequestMapping("/api")
public class ValoracionController {
    @Autowired
    private ValoracionService valoracionService;

    @PostMapping("/valoracion")
    public ValoracionDTO insertarValoracion(@RequestBody ValoracionDTO ValoracionDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Valoracion valoracion = modelMapper.map(ValoracionDTO, Valoracion.class);
        valoracion = valoracionService.insertarValoracion(valoracion);
        return modelMapper.map(valoracion, ValoracionDTO.class);
    }

    @GetMapping("/valoraciones")
    public List<ValoracionDTO> listarValoracions() {
        List<Valoracion> lista = valoracionService.listarValoracions();
        ModelMapper modelMapper = new ModelMapper();
        List<ValoracionDTO> listaDTO = modelMapper.map(lista, List.class);
        return listaDTO;
    }
    @GetMapping("/valoracionesT/{id}")
    public List<ValoracionDTO> listarValoracionesPorTecnico(@PathVariable Long id) {
        List<Valoracion> lista = valoracionService.findByTecnicoId(id);
        ModelMapper modelMapper = new ModelMapper();
        List<ValoracionDTO> listaDTO = modelMapper.map(lista, List.class);
        return listaDTO;
    }
    @GetMapping("/valoracionesC/{id}")
    public List<ValoracionDTO> listarValoracionesPorCliente(@PathVariable Long id) {
        List<Valoracion> lista = valoracionService.findByClienteId(id);
        ModelMapper modelMapper = new ModelMapper();
        List<ValoracionDTO> listaDTO = modelMapper.map(lista, List.class);
        return listaDTO;
    }

    @GetMapping("/filtrarTecnicosPorCalificacion/{calificacion}")
    public List<CountTecnicosPorCalificacionDTO> countTecnicosPorCalificacion(@PathVariable Double calificacion) {
        return valoracionService.filtrarTecnicosPorCalificacion(calificacion);
    }

    @PutMapping("/valoracion")
    public ValoracionDTO modificarValoracion(@RequestBody ValoracionDTO ValoracionDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Valoracion valoracion = modelMapper.map(ValoracionDTO, Valoracion.class);
        valoracion = valoracionService.modificarValoracion(valoracion);
        return modelMapper.map(valoracion, ValoracionDTO.class);
    }

    @DeleteMapping("/valoracion/{id}")
    public void eliminarValoracion(@PathVariable Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Valoracion valoracion = valoracionService.buscarPorId(id);
        valoracionService.eliminarValoracion(id);
        ValoracionDTO ValoracionDTO = modelMapper.map(valoracion, ValoracionDTO.class);
    }


}
