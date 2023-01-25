package com.az.ejemplobddos.controladores;

import com.az.ejemplobddos.entidades.Vehiculo;
import com.az.ejemplobddos.repositorios.RepositorioVehiculos;
import com.az.ejemplobddos.servicios.ServicioVehiculos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class ControladorVehiculos {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControladorVehiculos.class);
    RepositorioVehiculos repoVehiculos;
    ServicioVehiculos servVehiculos;

    public ControladorVehiculos(RepositorioVehiculos repoVehiculos,
                                ServicioVehiculos servVehiculos) {
        this.repoVehiculos = repoVehiculos;
        this.servVehiculos = servVehiculos;
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
           this.servVehiculos.guardarNuevo(nuevoV);
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

    @GetMapping(value="vehiculos", params={"k1","k2"})
    public List<Vehiculo> getPorRangoKilometraje(
            @RequestParam("k1") Double k1,
            @RequestParam("k2") Double k2
    ) {
        LOGGER.debug("GET porKilometraje: {}, {}", k1, k2);
        return this.repoVehiculos.buscarPorKilometraje(k1,k2);
    }
}
