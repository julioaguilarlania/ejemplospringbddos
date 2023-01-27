package com.az.ejemplobddos.controladores;

import com.az.ejemplobddos.entidades.LoginOTD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorUsuarios {

    private final static Logger LOGGER = LoggerFactory.getLogger(ControladorUsuarios.class);
    AuthenticationManager authManager;
    PasswordEncoder encoder;

    public ControladorUsuarios(AuthenticationManager authManager, PasswordEncoder encoder) {
        this.authManager = authManager;
        this.encoder = encoder;
    }

    @PostMapping("/api/login")
    public ResponseEntity<String> login(
            @RequestBody LoginOTD loginInfo
            ) {
        LOGGER.debug("POST login: usuario {}", loginInfo.getLogin());
        Authentication authResults = this.authManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginInfo.getLogin(), loginInfo.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authResults);
        return ResponseEntity.ok("Usuario atenticado");
    }
}
