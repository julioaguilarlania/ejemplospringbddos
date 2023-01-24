package com.az.ejemplobddos.repositorios;

import com.az.ejemplobddos.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioClientes extends JpaRepository<Cliente,Integer> {

    List<Cliente> findByNombre(String n);

    List<Cliente> findByNombreContaining(String cadena);
    List<Cliente> findByNombreContainingIgnoreCase(String cadena);
    List<Cliente> findByNombreContainingIgnoreCaseOrderByCurp(String cadena);
    List<Cliente> findByNombreStartingWithIgnoreCase(String cadena);
    List<Cliente> findByNombreEndingWithIgnoreCase(String cadena);
}
