package com.example.avancetf.serviceimpl;

import com.example.avancetf.Entities.Pago;
import com.example.avancetf.repositories.PagoRepositorio;
import com.example.avancetf.service.PagoServicee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PagoServiceImpl implements PagoServicee {
    @Autowired
    private PagoRepositorio pagoRepositorio;
    @Transactional
    public Pago insertarPago(@RequestBody Pago pago) {
        return pagoRepositorio.save(pago);
    }

    @Override
    public void eliminarPago(Long id) {
        if(pagoRepositorio.existsById(id)) {
            pagoRepositorio.deleteById(id);
        }
    }

    @Override
    public Pago modificarPago(Pago pago) {
        if(pagoRepositorio.existsById(pago.getId())){
            return pagoRepositorio.save(pago);
        }
        return null;
    }

    @Override
    public List<Pago> listarPagos() {
        return pagoRepositorio.findAll();
    }

}
