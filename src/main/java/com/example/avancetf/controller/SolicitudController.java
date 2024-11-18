package com.example.avancetf.controller;

import com.example.avancetf.Entities.Servicio;
import com.example.avancetf.Entities.SolicitudServicio;
import com.example.avancetf.Entities.Tecnico;
import com.example.avancetf.dtos.*;
import com.example.avancetf.service.SolicitudService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    @GetMapping("/solicitud/procesar/{id}")
    public void procesarSolicitudes(@PathVariable Long id) {
        solicitudService.procesarSolicitud(id);
    }
    @GetMapping("/solicitud/terminar/{id}")
    public void terminarSolicitudes(@PathVariable Long id) {
        solicitudService.TerminarSolicitud(id);
    }
    @GetMapping("/solicitudes/terminadaspor/{id}")
    public List<SolicitudServicioDTO> listarSolicitudesTerminadasDeTecnicoPorServicio(@PathVariable Long id) {
        List<SolicitudServicio> lista = solicitudService.findByEstadoAndServicioId("Terminado" , id);
        ModelMapper modelMapper = new ModelMapper();
        List<SolicitudServicioDTO> listaDTO = modelMapper.map(lista, List.class);
        return listaDTO;
    }
    @GetMapping("/solicitudes/cliente/{id}")
    public List<SolicitudServicioDTO> listarSolicitudesPorCliente(@PathVariable("id") Long id) {
        List<SolicitudServicio> lista = solicitudService.findByClienteIdAndEstado(id, "Terminado");
        ModelMapper modelMapper = new ModelMapper();
        List<SolicitudServicioDTO> listaDTO = modelMapper.map(lista, List.class);
        return listaDTO;
    }
    @GetMapping("/solicitud/cancelar/{id}")
    public void cancelarSolicitud(@PathVariable Long id) {
        solicitudService.cancelarSolicitud(id);
    }
    @GetMapping("/solicitud/filtrarEstado/{estado}/{idCliente}")
    public List<ServicioPorEstadoDTO>filtrarServiciosPorEstado(@PathVariable("estado") String estado, @PathVariable("idCliente") Long idCliente){
        return solicitudService.filtrarServiciosPorEstado(estado, idCliente);
    }
    @GetMapping ("/solicitud/mostrarDescFechas/{fechaInicio}/{fechaFin}")
    public List<CountNroSolicitudesSumMontoDTO>MostrarServiciosDescendentementePorCantidadMontoTotalEntreFechas(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
                                                                                                                @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin)
    {
        return solicitudService.MostrarServiciosDescendentementePorCantidadMontoTotalEntreFechas(fechaInicio, fechaFin);
    }
    @GetMapping("/solicitudes/tecnico/{id}")
    public List<SolicitudServicioDTO> findByServicioTecnicoId(@PathVariable Long id)
    {
        List<SolicitudServicio> lista = solicitudService.findByServicioTecnicoId(id);
        ModelMapper modelMapper = new ModelMapper();
        List<SolicitudServicioDTO> listaDTO = modelMapper.map(lista, List.class);
        return listaDTO;
    }

    @GetMapping ("/solicitud/mostrarAscFechas/{fechaInicio}/{fechaFin}")
    public List<CountNroSolicitudesSumMontoDTO>MostrarServiciosAscendentementePorCantidadMontoTotalEntreFechas(@PathVariable("fechaInicio") LocalDate fechaInicio, @PathVariable("fechaFin") LocalDate fechaFinal)
    {
        return solicitudService.MostrarServiciosAscendentementePorCantidadMontoTotalEntreFechas(fechaInicio, fechaFinal);
    }
    @GetMapping("/solicitud/{id}")
    public ResponseEntity<SolicitudServicioDTO> buscaTecnico(@PathVariable Long id) {
        ModelMapper modelMapper = new ModelMapper();
        SolicitudServicio solicitud = solicitudService.buscarPorId(id);
        SolicitudServicioDTO solicitudDTO = modelMapper.map(solicitud, SolicitudServicioDTO.class);
        return ResponseEntity.ok(solicitudDTO);
    }
}