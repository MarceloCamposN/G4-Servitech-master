package com.example.avancetf.controller;

import com.example.avancetf.Entities.User;
import com.example.avancetf.dtos.UsuarioDTO;
import com.example.avancetf.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200","http://18.216.202.149/"})
@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private PasswordEncoder bcrypt;
    @PostMapping("/usuario")
    @PreAuthorize("hasAnyRole('ADMIN','USER','TECNICO','CLIENTE')")
    public UsuarioDTO insertarUsuario(@RequestBody UsuarioDTO UsuarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        User usuario = modelMapper.map(UsuarioDTO, User.class);
        String bcryptPassword = bcrypt.encode(usuario.getPassword());
        usuario.setPassword(bcryptPassword);
        usuario = usuarioService.insertarUsuario(usuario);
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    @GetMapping("/usuarios")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public List<UsuarioDTO> listarUsuarios() {
        List<User> lista = usuarioService.listarUsuarios();
        ModelMapper modelMapper = new ModelMapper();
        List<UsuarioDTO> listaDTO = modelMapper.map(lista, List.class);
        return listaDTO;
    }
    @PutMapping("/usuario")
    @PreAuthorize("hasAnyRole('ADMIN','USER','TECNICO','CLIENTE')")
    public UsuarioDTO modificarUsuario(@RequestBody UsuarioDTO UsuarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        User usuario = modelMapper.map(UsuarioDTO, User.class);
        usuario = usuarioService.modificarUsuario(usuario);
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    @DeleteMapping("/usuario")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void eliminarUsuario(@RequestBody UsuarioDTO UsuarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        User usuario = modelMapper.map(UsuarioDTO, User.class);
        usuarioService.eliminarUsuario(usuario.getId());
    }

    @PostMapping("/save/{user_id}/{role_id}")
    @PreAuthorize("hasRole ('ADMIN')")
    public ResponseEntity<Integer> saveUserRole(@PathVariable("user_id") Long user_id, @PathVariable ("role_id")Long role_id) {
        return new ResponseEntity<Integer>(usuarioService.insertUserRol(user_id , role_id), HttpStatus.OK);
    }
}
