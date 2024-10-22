package com.blockbuster.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.blockbuster.entidades.Carritos;
import com.blockbuster.entidades.Clientes;

@Repository
public interface CarritosRepositorio extends JpaRepository<Carritos, Long> {
    Carritos findByCliente(Clientes cliente);
}