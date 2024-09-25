package com.example.avancetf.controller;

import com.example.avancetf.Entities.Valoracion;
import com.example.avancetf.dtos.CountTecnicosPorCalificacionDTO;
import com.example.avancetf.dtos.ValoracionDTO;
import com.example.avancetf.service.ValoracionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:4200","http://18.216.202.149/"})
@RestController
@RequestMapping("/api")
public class ValoracionController {
    @Autowired
    private ValoracionService valoracionService;

    @PostMapping("/valoracion")
    @PreAuthorize("hasAnyRole('ADMIN','CLIENTE')")
    public ValoracionDTO insertarValoracion(@RequestBody ValoracionDTO ValoracionDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Valoracion valoracion = modelMapper.map(ValoracionDTO, Valoracion.class);
        valoracion = valoracionService.insertarValoracion(valoracion);
        return modelMapper.map(valoracion, ValoracionDTO.class);
    }

    @GetMapping("/valoraciones")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ValoracionDTO> listarValoracions() {
        List<Valoracion> lista = valoracionService.listarValoracions();
        ModelMapper modelMapper = new ModelMapper();
        List<ValoracionDTO> listaDTO = modelMapper.map(lista, List.class);
        return listaDTO;
    }

    @GetMapping("/filtrarTecnicosPorCalificacion/{calificacion}")
    @PreAuthorize("hasAnyRole('ADMIN','CLIENTE')")
    public List<CountTecnicosPorCalificacionDTO> countTecnicosPorCalificacion(@PathVariable Double calificacion) {
        return valoracionService.filtrarTecnicosPorCalificacion(calificacion);
    }

    @PutMapping("/valoracion")
    @PreAuthorize("hasAnyRole('ADMIN','CLIENTE')")
    public ValoracionDTO modificarValoracion(@RequestBody ValoracionDTO ValoracionDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Valoracion valoracion = modelMapper.map(ValoracionDTO, Valoracion.class);
        valoracion = valoracionService.modificarValoracion(valoracion);
        return modelMapper.map(valoracion, ValoracionDTO.class);
    }

    @DeleteMapping("/valoracion")
    @PreAuthorize("hasAnyRole('ADMIN','CLIENTE')")
    public void eliminarValoracion(@RequestBody ValoracionDTO ValoracionDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Valoracion valoracion = modelMapper.map(ValoracionDTO, Valoracion.class);
        valoracionService.eliminarValoracion(valoracion.getId());
    }

}
