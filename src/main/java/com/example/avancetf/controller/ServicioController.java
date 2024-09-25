package com.example.avancetf.controller;
import com.example.avancetf.Entities.Servicio;
import com.example.avancetf.dtos.ServicioDTO;
import com.example.avancetf.service.ServicioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:4200","http://18.216.202.149/"})
@RestController
@RequestMapping("/api")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @PostMapping("/servicio")
    @PreAuthorize("hasAnyRole('TECNICO', 'ADMIN')")
    public ServicioDTO insertarServicio(@RequestBody ServicioDTO ServicioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Servicio servicio = modelMapper.map(ServicioDTO, Servicio.class);
        servicio = servicioService.insertarServicio(servicio);
        return modelMapper.map(servicio, ServicioDTO.class);
    }

    @GetMapping("/servicios")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public List<ServicioDTO> listarServicios() {
        List<Servicio> lista = servicioService.listarServicios();
        ModelMapper modelMapper = new ModelMapper();
        List<ServicioDTO> listaDTO = modelMapper.map(lista, List.class);
        return listaDTO;
    }

    @PutMapping("/servicio")
    @PreAuthorize("hasAnyRole('TECNICO', 'ADMIN')")
    public ServicioDTO modificarServicio(@RequestBody ServicioDTO ServicioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Servicio servicio = modelMapper.map(ServicioDTO, Servicio.class);
        servicio = servicioService.modificarServicio(servicio);
        return modelMapper.map(servicio, ServicioDTO.class);
    }

    @DeleteMapping("/servicio")
    @PreAuthorize("hasAnyRole('TECNICO', 'ADMIN')")
    public void eliminarServicio(@RequestBody ServicioDTO ServicioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Servicio servicio = modelMapper.map(ServicioDTO, Servicio.class);
        servicioService.eliminarServicio(servicio.getId());
    }}