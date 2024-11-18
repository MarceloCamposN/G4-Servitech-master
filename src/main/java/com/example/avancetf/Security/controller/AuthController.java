package com.example.avancetf.Security.controller;

import com.example.avancetf.Security.dtos.AuthRequestDTO;
import com.example.avancetf.Security.dtos.AuthResponseDTO;
import com.example.avancetf.Security.entities.User;
import com.example.avancetf.Security.services.CustomUserDetailsService;
import com.example.avancetf.Security.util.JwUtil;
import com.example.avancetf.repositories.ClienteRepositorio;
import com.example.avancetf.repositories.TecnicoRepositorio;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization")
@RestController
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwUtil jwtUtil;
    private final CustomUserDetailsService userDetailsService;
    private final TecnicoRepositorio tecnicoRepositorio;
    private final ClienteRepositorio clienteRepositorio;

    public AuthController(AuthenticationManager authenticationManager, JwUtil jwtUtil, CustomUserDetailsService userDetailsService, TecnicoRepositorio tecnicoRepositorio, ClienteRepositorio clienteRepositorio) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
        this.tecnicoRepositorio = tecnicoRepositorio;
        this.clienteRepositorio = clienteRepositorio;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequestDTO authRequest) throws Exception {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        final String token = jwtUtil.generateToken(userDetails);

        Set<String> roles = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());

        Long idTecnico = null;
        Long idCliente = null;
        if (roles.contains("ROLE_TECNICO")) {
            User user = userDetailsService.findUsuarioByUsername(authRequest.getUsername());
            idTecnico = tecnicoRepositorio.findIdByUsuarioId(user.getId());
        }
        if (roles.contains("ROLE_CLIENTE")) {
            User user = userDetailsService.findUsuarioByUsername(authRequest.getUsername());
            idCliente = clienteRepositorio.findIdByUsuarioId(user.getId());
        }

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Authorization", token);
        AuthResponseDTO authResponseDTO = new AuthResponseDTO();
        authResponseDTO.setRoles(roles);
        authResponseDTO.setJwt(token);
        authResponseDTO.setIdTecnico(idTecnico);
        authResponseDTO.setIdCliente(idCliente);
        return ResponseEntity.ok().headers(responseHeaders).body(authResponseDTO);
    }
}
