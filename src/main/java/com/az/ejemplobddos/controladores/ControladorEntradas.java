package com.az.ejemplobddos.controladores;

import com.az.ejemplobddos.entidades.Entrada;
import com.az.ejemplobddos.repositorios.RepositorioEntradas;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorEntradas {
    RepositorioEntradas repoEntradas;

    public ControladorEntradas(RepositorioEntradas repoEntradas) {
        this.repoEntradas = repoEntradas;
    }

    @GetMapping("entradas/en_progreso")
    public List<Entrada> getEntradasEnProgreso() {
        return repoEntradas.findByEstatus("EN_PROGRESO");
    }
}
