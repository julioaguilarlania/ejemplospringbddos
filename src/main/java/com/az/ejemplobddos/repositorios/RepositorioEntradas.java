package com.az.ejemplobddos.repositorios;

import com.az.ejemplobddos.entidades.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositorioEntradas extends JpaRepository<Entrada,Integer> {
    List<Entrada> findByEstatus(String st);

    @Query(value = "SELECT placas,fecha_ingreso FROM entradas WHERE estatus = :status",
            nativeQuery = true)
    List<Entrada> buscarPorEstatus(@Param("status") String st);

    @Query(value = "SELECT DATE_TRUNC(MONTH,FECHA_SALIDA) AS FECHA_SALIDA," +
            " COUNT(ENTRADA_ID) AS TOTAL" +
            " FROM ENTRADAS" +
            " GROUP BY DATE_TRUNC(MONTH,FECHA_SALIDA)" +
            " ORDER BY DATE_TRUNC(MONTH,FECHA_SALIDA)", nativeQuery = true)
    List<Object[]> obtenerTotalesPorMes();
}
