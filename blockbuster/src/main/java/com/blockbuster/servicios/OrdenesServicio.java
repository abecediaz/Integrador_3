package com.blockbuster.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import com.blockbuster.repositorios.OrdenesRepositorio;
import org.springframework.stereotype.Service;
import com.blockbuster.entidades.*;
import java.math.BigDecimal;
import java.util.*;

@Service
public class OrdenesServicio {

    @Autowired
    private OrdenesRepositorio  ordenesRepositorio;

    @Autowired
    private PeliculasServicio peliculasServicio;

    private Ordenes createOrden(Clientes cliente, Map<Long, Integer> ItemsCarritos){
        Ordenes orden = new Ordenes();
        orden.setCliente(cliente);

        BigDecimal monto_total = BigDecimal.ZERO;

        for(Map.Entry<Long, Integer> entry : ItemsCarritos.entrySet()){

            Peliculas pelicula = peliculasServicio.getPeliculaById(entry.getKey());
            ItemsOrdenes item_orden = new ItemsOrdenes();

            item_orden.setOrden(orden);
            item_orden.setPelicula(pelicula);
            item_orden.setCantidad_items_ordenes(entry.getValue());
            item_orden.setPrecio_items_ordenes(pelicula.getPrecio_peliculas());

            orden.getItem_orden().add(item_orden);

            monto_total = monto_total.add(pelicula.getPrecio_peliculas().multiply(BigDecimal.valueOf(entry.getValue())));
        }

        orden.setMonto_total(monto_total);
        return ordenesRepositorio.save(orden);
    }

    public Ordenes getOrdenById(Long id_ordenes){
        return ordenesRepositorio.findById(id_ordenes).orElse(null);
    }

    public List<Ordenes> getOrdenByCliente(Clientes cliente){
        return ordenesRepositorio.findOrdenByCliente(cliente);
    }

    public Ordenes updateOrden(Ordenes orden){
        return ordenesRepositorio.save(orden);
    }
}
