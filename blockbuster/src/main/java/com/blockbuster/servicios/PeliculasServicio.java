package com.blockbuster.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import com.blockbuster.repositorios.PeliculasRepositorio;
import com.blockbuster.repositorios.CarritosRepositorio;
import org.springframework.stereotype.Service;
import com.blockbuster.entidades.Peliculas;
import com.blockbuster.entidades.Carritos;
import com.blockbuster.entidades.Clientes;
import java.util.*;

@Service
public class PeliculasServicio {

    @Autowired
    private PeliculasRepositorio peliculasRepositorio;

    @Autowired
    private CarritosRepositorio carritosRepositorio;

    public List<Peliculas> getAllPeliculas() {
        return peliculasRepositorio.findAll();
    }

    public Peliculas getPeliculaById(Long id_peliculas) {
        return peliculasRepositorio.findById(id_peliculas).orElse(null);
    }

    public Peliculas savePelicula(Peliculas pelicula) {
        return peliculasRepositorio.save(pelicula);
    }

    public void deletePelicula(Long id_peliculas) {
        peliculasRepositorio.deleteById(id_peliculas);
    }

    public Carritos getCarrito(Clientes cliente) {
        return carritosRepositorio.findByCliente(cliente);
    }

    public Double calcularTotal(Clientes cliente) {

        Carritos carrito = carritosRepositorio.findByCliente(cliente);

        if (carrito == null) {
            return 0.0;
        }

        if (carrito.getItem_carrito().isEmpty()) {
            return 0.0;
        }

        return carrito.getItem_carrito().stream().mapToDouble(pelicula -> pelicula.getPelicula().getPrecio_peliculas().doubleValue() * pelicula.getCantidad_items_carritos()).sum();
    }
}
