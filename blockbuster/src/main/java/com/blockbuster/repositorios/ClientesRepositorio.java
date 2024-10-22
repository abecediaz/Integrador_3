package com.blockbuster.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.blockbuster.entidades.Clientes;
import java.util.Optional;

@Repository
public interface ClientesRepositorio extends JpaRepository<Clientes, Long> {
    Optional<Clientes> findByUsuario(String usuario);
}
