package com.example.avancetf.controller;

import com.example.avancetf.Entities.Administrador;
import com.example.avancetf.dtos.AdministradorDTO;
import com.example.avancetf.service.AdministradorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:4200","http://18.216.202.149/"})
@RestController
@RequestMapping("/api")
public class AdministradorController {
    @Autowired
    private AdministradorService administradorService;

    @PostMapping("/administrador")
    public AdministradorDTO insertarAdministrador(@RequestBody AdministradorDTO AdministradorDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Administrador administrador = modelMapper.map(AdministradorDTO, Administrador.class);
        administrador = administradorService.insertarAdministrador(administrador);
        return modelMapper.map(administrador, AdministradorDTO.class);
    }

    @GetMapping("/administradores")
    public List<AdministradorDTO> listarAdministradors() {
        List<Administrador> lista = administradorService.listarAdministradores();
        ModelMapper modelMapper = new ModelMapper();
        List<AdministradorDTO> listaDTO = modelMapper.map(lista, List.class);
        return listaDTO;
    }

    @PutMapping("/administrador")
    public AdministradorDTO modificarAdministrador(@RequestBody AdministradorDTO AdministradorDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Administrador administrador = modelMapper.map(AdministradorDTO, Administrador.class);
        administrador = administradorService.modificarAdministrador(administrador);
        return modelMapper.map(administrador, AdministradorDTO.class);
    }

    @DeleteMapping("/administrador")
    public void eliminarAdministrador(@RequestBody AdministradorDTO AdministradorDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Administrador administrador = modelMapper.map(AdministradorDTO, Administrador.class);
        administradorService.eliminarAdministrador(administrador.getId());
    }
}
