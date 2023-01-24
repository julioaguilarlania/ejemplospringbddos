package com.az.ejemplobddos.servicios;

import com.az.ejemplobddos.entidades.Cliente;
import com.az.ejemplobddos.entidades.Vehiculo;
import com.az.ejemplobddos.repositorios.RepositorioClientes;
import com.az.ejemplobddos.repositorios.RepositorioVehiculos;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ServicioVehiculos {

    RepositorioVehiculos repoVehiculos;
    RepositorioClientes repoClientes;

    public ServicioVehiculos(RepositorioVehiculos repoVehiculos,
                             RepositorioClientes repoClientes) {
        this.repoVehiculos = repoVehiculos;
        this.repoClientes = repoClientes;
    }

    @Transactional
    public Vehiculo guardarNuevo(Vehiculo v) {
        Cliente cl = v.getCliente();
        if (cl != null && cl.getClienteId() != null) {
            Optional<Cliente> opCl = repoClientes.findById(cl.getClienteId());
            if (opCl.isPresent()) {
                // Cliente existe, solo guardamos Vehiculo
                v = repoVehiculos.save(v);
                return v;
            }
        }
        cl.setClienteId(null);
        cl = repoClientes.save(cl);
        v.setCliente(cl);
        return repoVehiculos.save(v);
    }
}
