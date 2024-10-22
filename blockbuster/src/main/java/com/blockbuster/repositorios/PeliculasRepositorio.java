package com.blockbuster.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.blockbuster.entidades.Peliculas;

@Repository
public interface PeliculasRepositorio extends JpaRepository<Peliculas, Long> {
}