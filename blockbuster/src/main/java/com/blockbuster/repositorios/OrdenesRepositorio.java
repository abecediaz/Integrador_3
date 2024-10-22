package com.blockbuster.repositorios;

import com.blockbuster.entidades.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.blockbuster.entidades.Ordenes;
import java.util.*;

@Repository
public interface OrdenesRepositorio extends JpaRepository<Ordenes, Long> {
    List<Ordenes> findOrdenByCliente(Clientes cliente);
}
