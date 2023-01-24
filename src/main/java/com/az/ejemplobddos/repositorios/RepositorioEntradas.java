package com.az.ejemplobddos.repositorios;

import com.az.ejemplobddos.entidades.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioEntradas extends JpaRepository<Entrada,Integer> {
}
