package com.example.avancetf.Security.services;

import com.example.avancetf.Security.entities.User;

import java.util.List;


public interface UsuarioService {
    public User insertarUsuario(User usuario);
    public void eliminarUsuario(Long id);
    public User modificarUsuario(User usuario);
    public List<User> listarUsuarios();
    public Integer insertUserRol(Long user_id, Long rol_id);
    public User buscarPorID(Long id);
}
