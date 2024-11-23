package com.example.avancetf.Security.config;

import com.example.avancetf.Security.filters.JwtRequestFilter;
import com.example.avancetf.Security.services.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

//(3,4,5,6,7,8)
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;
    private final JwtRequestFilter jwtRequestFilter;

    //Inyectando JWT Filter por constructor
    public SecurityConfig(CustomUserDetailsService userDetailsService, JwtRequestFilter jwtRequestFilter) {
        this.userDetailsService = userDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    //se define como un bean para que pueda ser utilizado en otros lugares, como en el controlador de autenticación
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    // Bean para codificar las contraseñas para ser usando en cualquier parte de la app
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Definir el SecurityFilterChain como un bean, ya no necesitamos heredar, configuramos toda la seg.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // CSRF desactivado para APIs REST
                .cors(cors -> cors.configurationSource(request -> { // Configuración de CORS
                    CorsConfiguration configuration = new CorsConfiguration();
                    configuration.setAllowedOrigins(List.of("http://localhost:4200")); // Permitir solo tu frontend
                    configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Métodos permitidos
                    configuration.setAllowedHeaders(List.of("Authorization", "Content-Type")); // Headers permitidos
                    configuration.setExposedHeaders(List.of("Authorization"));
                    configuration.setAllowCredentials(true); // Para enviar cookies o tokens
                    return configuration;
                }))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/authenticate",  // Endpoint para autenticación
                                "/api/usuario",
                                "/api/usuarios",
                                "api/save/**",
                                "api/cliente",
                                "api/tecnico",
                                "api/usuario/*"// Endpoint para registrar usuario
                        ).permitAll() // Permitir acceso sin autenticación
                        .anyRequest().authenticated() // Proteger todos los demás endpoints
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        // Añadir el filtro JWT antes del filtro de autenticación
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
