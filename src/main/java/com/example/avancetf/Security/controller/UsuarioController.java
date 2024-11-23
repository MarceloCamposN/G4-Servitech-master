package com.example.avancetf.Security.controller;

import com.example.avancetf.Security.entities.User;
import com.example.avancetf.dtos.UsuarioDTO;
import com.example.avancetf.Security.services.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200","http://18.219.237.192/"})
@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @PostMapping("/usuario")
    public UsuarioDTO insertarUsuario(@RequestBody UsuarioDTO UsuarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        User usuario = modelMapper.map(UsuarioDTO, User.class);
        usuario = usuarioService.insertarUsuario(usuario);
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    @GetMapping("/usuarios")
    public List<UsuarioDTO> listarUsuarios() {
        List<User> lista = usuarioService.listarUsuarios();
        ModelMapper modelMapper = new ModelMapper();
        List<UsuarioDTO> listaDTO = modelMapper.map(lista, List.class);
        return listaDTO;
    }
    @PutMapping("/usuario")
    public UsuarioDTO modificarUsuario(@RequestBody UsuarioDTO UsuarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        User usuario = modelMapper.map(UsuarioDTO, User.class);
        usuario = usuarioService.modificarUsuario(usuario);
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    @DeleteMapping("/usuario")
    public void eliminarUsuario(@RequestBody UsuarioDTO UsuarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        User usuario = modelMapper.map(UsuarioDTO, User.class);
        usuarioService.eliminarUsuario(usuario.getId());
    }

    @PostMapping("/save/{user_id}/{role_id}")
    public ResponseEntity<Integer> saveUserRole(@PathVariable("user_id") Long user_id, @PathVariable ("role_id")Long role_id) {
        return new ResponseEntity<Integer>(usuarioService.insertUserRol(user_id , role_id), HttpStatus.OK);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<UsuarioDTO> buscaUser(@PathVariable Long id) {
        ModelMapper modelMapper = new ModelMapper();
        User usuario = usuarioService.buscarPorID(id);
        UsuarioDTO usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
        return ResponseEntity.ok(usuarioDTO);
    }
}
