package com.az.ejemplobddos.controladores;

import com.az.ejemplobddos.entidades.Entrada;
import com.az.ejemplobddos.entidades.Vehiculo;
import com.az.ejemplobddos.repositorios.RepositorioEntradas;
import com.az.ejemplobddos.repositorios.RepositorioVehiculos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class ControladorRestVehiculos {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControladorRestVehiculos.class);
    RepositorioVehiculos repoVehiculos;

    public ControladorRestVehiculos(RepositorioVehiculos repoVehiculos) {
        this.repoVehiculos = repoVehiculos;
    }

    @GetMapping("vehiculos")
    public List<Vehiculo> getTodos() {
        LOGGER.debug("GET vehiculos");
        return this.repoVehiculos.findAll();
    }

    @GetMapping("vehiculos/{placas}")
    public ResponseEntity<Vehiculo> getPorPlacas(
            @PathVariable("placas") String p
    ) {
        LOGGER.debug("GET vehiculos placas:{}", p);
        Optional<Vehiculo> opv = this.repoVehiculos.findById(p);
        if (opv.isPresent()) {
            return ResponseEntity.ok(opv.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("vehiculos")
    public ResponseEntity<Vehiculo> crear(
            @RequestBody Vehiculo nuevoV
    ) {
       try {
           this.repoVehiculos.save(nuevoV);
           return ResponseEntity
                   .created(new URI("vehiculos/" + nuevoV.getPlacas()))
                   .body(nuevoV);
       }
       catch (Exception ex) {
           return ResponseEntity.status(400)
                   .header("ERROR", ex.getMessage())
                   .build();
       }
    }

    @PutMapping("vehiculos/{placas}")
    public ResponseEntity<Vehiculo> actualizar(
            @RequestBody Vehiculo v,
            @PathVariable("placas") String p) {
        try {
            v.setPlacas(p);
            this.repoVehiculos.save(v);
            return ResponseEntity.ok(v);
        }
        catch (Exception ex) {
            return ResponseEntity.status(400)
                    .header("ERROR", ex.getMessage())
                    .build();
        }
    }

    @DeleteMapping("vehiculos/{placas}")
    public ResponseEntity borrar(@PathVariable("placas") String p) {
        this.repoVehiculos.deleteById(p);
        return ResponseEntity.ok().build();
    }
}
