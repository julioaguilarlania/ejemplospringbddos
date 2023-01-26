package com.az.ejemplobddos.controladores;

import com.az.ejemplobddos.entidades.Entrada;
import com.az.ejemplobddos.entidades.V_TotalPorMes;
import com.az.ejemplobddos.repositorios.RepositorioEntradas;
import com.az.ejemplobddos.repositorios.RepositorioV_TotalesPorMes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ControladorEntradas {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControladorEntradas.class);
    RepositorioEntradas repoEntradas;
    RepositorioV_TotalesPorMes repoTotales;

    public ControladorEntradas(RepositorioEntradas repoEntradas, RepositorioV_TotalesPorMes repoTotales) {
        this.repoEntradas = repoEntradas;
        this.repoTotales = repoTotales;
    }

    @GetMapping(value="entradas/en_progreso",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
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

    @PutMapping("entradas/cerrar_pendientes")
    @Transactional
    public ResponseEntity cerrarEntradasPendientes() {
        LOGGER.debug("PUT cerrarEntradas");
        LocalDateTime ahora = LocalDateTime.now();
        int conteo = this.repoEntradas.cerrarEntradasPendientes(ahora);
        return ResponseEntity.ok()
                .header("Actualizados", String.valueOf(conteo))
                .build();
    }

    @GetMapping("bajo_nivel")
    public ResponseEntity metodo(HttpServletRequest peticion,
                                 HttpServletResponse respuesta,
                                 HttpSession sesion,
                                 @RequestParam("val") String val) {
        LOGGER.debug("Peticion de tipo {}", peticion.getContentType());
        String valorGuardado = (String) sesion.getAttribute("VALOR");
        if (valorGuardado == null) valorGuardado = "";
        valorGuardado = valorGuardado + "," + val;
        sesion.setAttribute("VALOR", valorGuardado);
        return ResponseEntity.ok(valorGuardado);
    }

}
