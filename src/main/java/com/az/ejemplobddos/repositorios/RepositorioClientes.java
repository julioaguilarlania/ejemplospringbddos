package com.az.ejemplobddos.repositorios;

import com.az.ejemplobddos.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioClientes extends JpaRepository<Cliente,Integer> {
}
