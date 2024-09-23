package com.example.avancetf.controller;

import com.example.avancetf.Entities.SolicitudServicio;
import com.example.avancetf.dtos.SolicitudServicioDTO;
import com.example.avancetf.service.SolicitudService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:4200","http://18.216.202.149/"})
@RestController
@RequestMapping("/api")
public class SolicitudController {
    @Autowired
    private SolicitudService solicitudService;

    @PostMapping("/solicitud")
    public SolicitudServicioDTO insertarSolicitud(@RequestBody SolicitudServicioDTO SolicitudServicioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        SolicitudServicio solicitud = modelMapper.map(SolicitudServicioDTO, SolicitudServicio.class);
        solicitud = solicitudService.insertarSolicitud(solicitud);
        return modelMapper.map(solicitud, SolicitudServicioDTO.class);
    }



    @PutMapping("/solicitud")
    public SolicitudServicioDTO modificarSolicitud(@RequestBody SolicitudServicioDTO SolicitudServicioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        SolicitudServicio solicitud = modelMapper.map(SolicitudServicioDTO, SolicitudServicio.class);
        solicitud = solicitudService.modificarSolicitud(solicitud);
        return modelMapper.map(solicitud, SolicitudServicioDTO.class);
    }

    @DeleteMapping("/solicitud")
    public void eliminarSolicitud(@RequestBody SolicitudServicioDTO SolicitudServicioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        SolicitudServicio solicitud = modelMapper.map(SolicitudServicioDTO, SolicitudServicio.class);
        solicitudService.eliminarSolicitud(solicitud.getId());
    }

    @GetMapping("/solicitudes")
    public List<SolicitudServicioDTO> listarSolicitudes() {
        List<SolicitudServicio> lista = solicitudService.listarSolicitudes();
        ModelMapper modelMapper = new ModelMapper();
        List<SolicitudServicioDTO> listaDTO = modelMapper.map(lista, List.class);
        return listaDTO;
    }
    @GetMapping("/solicitudes/terminadaspor/{id}") //el servicio fue terminado exitosamente
    public List<SolicitudServicioDTO> listarSolicitudesTerminadasDeTecnico(@PathVariable Long id) {
        List<SolicitudServicio> lista = solicitudService.findByEstadoAndServicioTecnicoId("Terminado" , id);
        ModelMapper modelMapper = new ModelMapper();
        List<SolicitudServicioDTO> listaDTO = modelMapper.map(lista, List.class);
        return listaDTO;
    }
    @GetMapping("/solicitudes/cliente/{id}") //listar solicitudes por cliente
    public List<SolicitudServicioDTO> listarSolicitudesPorCliente(@PathVariable Long id) {
        List<SolicitudServicio> lista = solicitudService.findByClienteId(id);
        ModelMapper modelMapper = new ModelMapper();
        List<SolicitudServicioDTO> listaDTO = modelMapper.map(lista, List.class);
        return listaDTO;
    }
    @DeleteMapping("/solicitud/cancelar")
    public ResponseEntity<String>  cancelarSolicitud(@RequestBody SolicitudServicioDTO SolicitudServicioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        SolicitudServicio solicitud = modelMapper.map(SolicitudServicioDTO, SolicitudServicio.class);

        try {
            solicitudService.cancelarSolicitud(solicitud.getId());
            return ResponseEntity.ok("Solicitud cancelada con éxito.");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

}