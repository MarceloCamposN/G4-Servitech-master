package com.example.avancetf.controller;

import com.example.avancetf.Entities.SolicitudServicio;
import com.example.avancetf.dtos.CountNroSolicitudesSumMontoDTO;
import com.example.avancetf.dtos.ServicioPorEstadoDTO;
import com.example.avancetf.dtos.SolicitudServicioDTO;
import com.example.avancetf.service.SolicitudService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyRole('CLIENTE', 'ADMIN')")
    public SolicitudServicioDTO insertarSolicitud(@RequestBody SolicitudServicioDTO SolicitudServicioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        SolicitudServicio solicitud = modelMapper.map(SolicitudServicioDTO, SolicitudServicio.class);
        solicitud = solicitudService.insertarSolicitud(solicitud);
        return modelMapper.map(solicitud, SolicitudServicioDTO.class);
    }



    @PutMapping("/solicitud")
    @PreAuthorize("hasAnyRole('CLIENTE', 'ADMIN')")
    public SolicitudServicioDTO modificarSolicitud(@RequestBody SolicitudServicioDTO SolicitudServicioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        SolicitudServicio solicitud = modelMapper.map(SolicitudServicioDTO, SolicitudServicio.class);
        solicitud = solicitudService.modificarSolicitud(solicitud);
        return modelMapper.map(solicitud, SolicitudServicioDTO.class);
    }

    @DeleteMapping("/solicitud")
    @PreAuthorize("hasAnyRole('CLIENTE', 'ADMIN')")
    public void eliminarSolicitud(@RequestBody SolicitudServicioDTO SolicitudServicioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        SolicitudServicio solicitud = modelMapper.map(SolicitudServicioDTO, SolicitudServicio.class);
        solicitudService.eliminarSolicitud(solicitud.getId());
    }

    @GetMapping("/solicitudes")
    @PreAuthorize("hasAnyRole('CLIENTE', 'ADMIN')")
    public List<SolicitudServicioDTO> listarSolicitudes() {
        List<SolicitudServicio> lista = solicitudService.listarSolicitudes();
        ModelMapper modelMapper = new ModelMapper();
        List<SolicitudServicioDTO> listaDTO = modelMapper.map(lista, List.class);
        return listaDTO;
    }

    @GetMapping("/solicitudes/terminadaspor/{id}")
    @PreAuthorize("hasAnyRole('CLIENTE','ADMIN')") //el servicio fue terminado exitosamente
    public List<SolicitudServicioDTO> listarSolicitudesTerminadasDeTecnico(@PathVariable Long id) {
        List<SolicitudServicio> lista = solicitudService.findByEstadoAndServicioTecnicoId("Terminado" , id);
        ModelMapper modelMapper = new ModelMapper();
        List<SolicitudServicioDTO> listaDTO = modelMapper.map(lista, List.class);
        return listaDTO;
    }
    @GetMapping("/solicitudes/cliente/{id}")
    @PreAuthorize("hasAnyRole('CLIENTE','ADMIN')")//listar solicitudes por cliente
    public List<SolicitudServicioDTO> listarSolicitudesPorCliente(@PathVariable("id") Long id) {
        List<SolicitudServicio> lista = solicitudService.findByClienteId(id);
        ModelMapper modelMapper = new ModelMapper();
        List<SolicitudServicioDTO> listaDTO = modelMapper.map(lista, List.class);
        return listaDTO;
    }
    @DeleteMapping("/solicitud/cancelar")
    @PreAuthorize("hasAnyRole('CLIENTE','ADMIN')")
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
    @GetMapping("/solicitud/filtrarEstado/{estado}/{idCliente}")
    @PreAuthorize("hasAnyRole('CLIENTE','ADMIN')")
    public List<ServicioPorEstadoDTO>filtrarServiciosPorEstado(@PathVariable("estado") String estado, @PathVariable("idCliente") Long idCliente){
        return solicitudService.filtrarServiciosPorEstado(estado, idCliente);
    }
    @GetMapping ("/solicitud/mostrarDescFechas/{fechaInicio}/{fechaFin}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public List<CountNroSolicitudesSumMontoDTO>MostrarServiciosDescendentementePorCantidadMontoTotalEntreFechas(@PathVariable("fechaInicio") LocalDate fechaInicio, @PathVariable("fechaFin") LocalDate fechaFinal)
    {
        return solicitudService.MostrarServiciosDescendentementePorCantidadMontoTotalEntreFechas(fechaInicio, fechaFinal);
    }
    @GetMapping ("/solicitud/mostrarAscFechas/{fechaInicio}/{fechaFin}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public List<CountNroSolicitudesSumMontoDTO>MostrarServiciosAscendentementePorCantidadMontoTotalEntreFechas(@PathVariable("fechaInicio") LocalDate fechaInicio, @PathVariable("fechaFin") LocalDate fechaFinal)
    {
        return solicitudService.MostrarServiciosAscendentementePorCantidadMontoTotalEntreFechas(fechaInicio, fechaFinal);
    }

}