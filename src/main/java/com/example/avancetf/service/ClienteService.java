package com.example.avancetf.service;

import com.example.avancetf.Entities.Cliente;
import com.example.avancetf.Entities.Servicio;

import java.util.List;

public interface ClienteService {
    public Cliente insertarCliente(Cliente cliente);
    public void eliminarCliente(Long  id);
    public Cliente modificarCliente(Cliente cliente);
    public List<Cliente> listarClientes();
    public Cliente buscarPorId(Long id);
    }
