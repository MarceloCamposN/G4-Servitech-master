package com.example.avancetf.serviceimpl;

import com.example.avancetf.Security.entities.User;
import com.example.avancetf.Security.services.UsuarioService;
import com.example.avancetf.repositories.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Transactional
    public User insertarUsuario(@RequestBody User usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        if(usuarioRepositorio.existsById(id)) {
            usuarioRepositorio.deleteById(id);
        }
    }

    @Override
    public User modificarUsuario(User usuario) {
        if(usuarioRepositorio.existsById(usuario.getId())){
            return usuarioRepositorio.save(usuario);
        }
        return null;
    }

    @Override
    public List<User> listarUsuarios() {
        return usuarioRepositorio.findByEliminadoFalse();
    }

    public Integer insertUserRol(Long user_id, Long rol_id) {
        Integer result = 0;
        usuarioRepositorio.insertUserRol(user_id, rol_id);
        return 1;
    }

    @Override
    public User buscarPorID(Long id) {
        if(usuarioRepositorio.findById(id).isPresent()){
            return usuarioRepositorio.findById(id).get();
        }
        return null;
    }

}
