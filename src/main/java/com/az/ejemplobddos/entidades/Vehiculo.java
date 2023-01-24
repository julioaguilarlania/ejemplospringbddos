package com.az.ejemplobddos.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalField;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    public Vehiculo() {
    }

    public Vehiculo(String placas, String color, String marca, String modelo, Double kilometraje, LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
        this.placas = placas;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.kilometraje = kilometraje;
    }

    @Id
    private String placas;
    @Basic
    private String color;
    @Basic
    private String marca;
    @Basic
    private String modelo;
    @Basic
    private Double kilometraje;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
