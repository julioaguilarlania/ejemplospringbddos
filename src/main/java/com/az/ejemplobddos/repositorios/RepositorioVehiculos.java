package com.az.ejemplobddos.repositorios;

import com.az.ejemplobddos.entidades.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioVehiculos extends JpaRepository<Vehiculo,String> {
}
