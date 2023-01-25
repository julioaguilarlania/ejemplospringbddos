package com.az.ejemplobddos.controladores;

import com.az.ejemplobddos.entidades.Entrada;
import com.az.ejemplobddos.entidades.V_TotalPorMes;
import com.az.ejemplobddos.repositorios.RepositorioEntradas;
import com.az.ejemplobddos.repositorios.RepositorioV_TotalesPorMes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorEntradas {
    RepositorioEntradas repoEntradas;
    RepositorioV_TotalesPorMes repoTotales;

    public ControladorEntradas(RepositorioEntradas repoEntradas, RepositorioV_TotalesPorMes repoTotales) {
        this.repoEntradas = repoEntradas;
        this.repoTotales = repoTotales;
    }

    @GetMapping("entradas/en_progreso")
    public List<Entrada> getEntradasEnProgreso() {
        return repoEntradas.findByEstatus("EN_PROGRESO");
    }

    @GetMapping("entradas/totales")
    public List<Object[]> getArregloTotalesPorMes() {
        return this.repoEntradas.obtenerTotalesPorMes();
    }

    @GetMapping("entradas/totales_por_mes")
    public List<V_TotalPorMes> getTotalesPorMes() {
        return this.repoTotales.findAll();
    }
}
