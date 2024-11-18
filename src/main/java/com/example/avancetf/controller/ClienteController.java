package com.example.avancetf.controller;

import com.example.avancetf.Entities.Cliente;
import com.example.avancetf.Entities.Cliente;
import com.example.avancetf.dtos.ClienteDTO;
import com.example.avancetf.dtos.ClienteDTO;
import com.example.avancetf.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:4200","http://18.216.202.149/"})
@RestController
@RequestMapping("/api")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cliente")
    public ClienteDTO insertarCliente(@RequestBody ClienteDTO ClienteDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Cliente cliente = modelMapper.map(ClienteDTO, Cliente.class);
        cliente = clienteService.insertarCliente(cliente);
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    @GetMapping("/clientes")
    public List<ClienteDTO> listarClientes() {
        List<Cliente> lista = clienteService.listarClientes();
        ModelMapper modelMapper = new ModelMapper();
        List<ClienteDTO> listaDTO = modelMapper.map(lista, List.class);
        return listaDTO;
    }

    @PutMapping("/cliente")
    public ClienteDTO modificarCliente(@RequestBody ClienteDTO ClienteDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Cliente cliente = modelMapper.map(ClienteDTO, Cliente.class);
        cliente = clienteService.modificarCliente(cliente);
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    @DeleteMapping("/cliente")
    public void eliminarCliente(@RequestBody ClienteDTO ClienteDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Cliente cliente = modelMapper.map(ClienteDTO, Cliente.class);
        clienteService.eliminarCliente(cliente.getId());
    }
    @GetMapping("/cliente/{id}")
    public ResponseEntity<ClienteDTO> buscaCliente(@PathVariable Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Cliente cliente = clienteService.buscarPorId(id);
        ClienteDTO clienteDTO = modelMapper.map(cliente, ClienteDTO.class);
        return ResponseEntity.ok(clienteDTO);
    }
}
