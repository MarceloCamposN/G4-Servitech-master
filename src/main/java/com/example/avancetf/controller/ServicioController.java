package com.example.avancetf.controller;
import com.example.avancetf.Entities.Servicio;
import com.example.avancetf.dtos.ServicioDTO;
import com.example.avancetf.service.ServicioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:4200","http://18.216.202.149/"})
@RestController
@RequestMapping("/api")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @PostMapping("/servicio")
    public ServicioDTO insertarServicio(@RequestBody ServicioDTO ServicioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Servicio servicio = modelMapper.map(ServicioDTO, Servicio.class);
        servicio = servicioService.insertarServicio(servicio);
        return modelMapper.map(servicio, ServicioDTO.class);
    }

    @GetMapping("/servicios")
    public List<ServicioDTO> listarServicios() {
        List<Servicio> lista = servicioService.listarServicios("Disponible");
        ModelMapper modelMapper = new ModelMapper();
        List<ServicioDTO> listaDTO = modelMapper.map(lista, List.class);
        return listaDTO;
    }

    @PutMapping("/servicio")
    public ServicioDTO modificarServicio(@RequestBody ServicioDTO ServicioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Servicio servicio = modelMapper.map(ServicioDTO, Servicio.class);
        servicio = servicioService.modificarServicio(servicio);
        return modelMapper.map(servicio, ServicioDTO.class);
    }

    @DeleteMapping("/servicio")
    public void eliminarServicio(@RequestBody ServicioDTO ServicioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Servicio servicio = modelMapper.map(ServicioDTO, Servicio.class);
        servicioService.eliminarServicio(servicio.getId());
    }
    @DeleteMapping("/servicioL/{id}")
    public ResponseEntity<ServicioDTO>eliminarServicioLogico(@PathVariable Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Servicio servicio = servicioService.buscarPorId(id);
        servicioService.eliminarLogicoServicio(servicio.getId());
        ServicioDTO servicioDTO = modelMapper.map(servicio, ServicioDTO.class);
        return ResponseEntity.ok(servicioDTO);
    }
    @GetMapping("/servicio/{id}")
    public ResponseEntity<ServicioDTO> buscaServicio(@PathVariable Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Servicio servicio = servicioService.buscarPorId(id);
        ServicioDTO servicioDTO = modelMapper.map(servicio, ServicioDTO.class);
        return ResponseEntity.ok(servicioDTO);
    }
    @GetMapping("/servicios/tecnico/{id}")
    public List<ServicioDTO> listarServicios(@PathVariable Long id) {
        List<Servicio> lista = servicioService.findByTecnicoAndEliminadoFalse(id);
        ModelMapper modelMapper = new ModelMapper();
        List<ServicioDTO> listaDTO = modelMapper.map(lista, List.class);
        return listaDTO;
    }
}
