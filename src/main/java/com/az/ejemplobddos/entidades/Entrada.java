package com.az.ejemplobddos.entidades;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="entradas")
public class Entrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer entradaId;

    @ManyToOne
    @JoinColumn(name="placas")
    Vehiculo vehiculo;

    @Basic
    @Column(name="fecha_ingreso")
    private LocalDateTime fechaIngreso;

    @Basic
    @Column(name="fecha_salida")
    private LocalDateTime fechaSalida;

    @Basic
    private String estatus;

    public Integer getEntradaId() {
        return entradaId;
    }

    public void setEntradaId(Integer entradaId) {
        this.entradaId = entradaId;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
