package com.example.avancetf.controller;

import com.example.avancetf.Entities.Pago;
import com.example.avancetf.dtos.PagoDTO;
import com.example.avancetf.service.PagoServicee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200","http://18.216.202.149/"})
@RestController
@RequestMapping("/api")
public class PagoController {
    @Autowired
    private PagoServicee pagoService;
    //@Autowired
    //private PasswordEncoder bcrypt;
    @PostMapping("/pago")
    public PagoDTO insertarPago(@RequestBody PagoDTO PagoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Pago pago = modelMapper.map(PagoDTO, Pago.class);
        pago = pagoService.insertarPago(pago);
        return modelMapper.map(pago, PagoDTO.class);
    }

    @GetMapping("/pagos")
    public List<PagoDTO> listarPagos() {
        List<Pago> lista = pagoService.listarPagos();
        ModelMapper modelMapper = new ModelMapper();
        List<PagoDTO> listaDTO = modelMapper.map(lista, List.class);
        return listaDTO;
    }
    @PutMapping("/pago")
    public PagoDTO modificarPago(@RequestBody PagoDTO PagoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Pago pago = modelMapper.map(PagoDTO, Pago.class);
        pago = pagoService.modificarPago(pago);
        return modelMapper.map(pago, PagoDTO.class);
    }

    @DeleteMapping("/pago")
    public void eliminarPago(@RequestBody PagoDTO PagoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Pago pago = modelMapper.map(PagoDTO, Pago.class);
        pagoService.eliminarPago(pago.getId());
    }
}
