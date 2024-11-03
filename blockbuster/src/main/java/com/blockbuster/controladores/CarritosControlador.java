package com.blockbuster.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import com.blockbuster.repositorios.CarritosRepositorio;
import com.blockbuster.servicios.PeliculasServicio;
import com.blockbuster.servicios.ClientesServicio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.blockbuster.servicios.OrdenesServicio;
import com.blockbuster.entidades.Carritos;
import org.springframework.ui.Model;
import java.util.*;

@Controller
@RequestMapping("/carrito")
public class CarritosControlador {

    @Autowired
    private ClientesServicio clientesServicio;

    @Autowired
    private PeliculasServicio peliculasServicio;

    @Autowired
    private OrdenesServicio ordenesServicio;

    @Autowired
    private CarritosRepositorio carritosRepositorio;

    @GetMapping
    public String viewCarritos(Model model, @SessionAttribute(value = "carritos", required = false) Map<Long, Integer> carritos) {

        if (carritos == null) {
            carritos = new HashMap<>();
        }

        Carritos carrito_cliente = peliculasServicio.getCarrito(clientesServicio.getLoggedUsername());

        if (carrito_cliente == null) {
            carrito_cliente = new Carritos();
            carrito_cliente.setItem_carrito(new ArrayList<>());
        }

        model.addAttribute("items_carritos", carrito_cliente);
        model.addAttribute("monto_total", peliculasServicio.calcularTotal(clientesServicio.getLoggedUsername()));

        return "carrito";
    }

    @PostMapping("/agregar/{id_peliculas}")
    public String addToCarritos(@PathVariable Long id_peliculas, @RequestParam(defaultValue = "1") int cantidad_items_carritos, @SessionAttribute(value = "carritos", required = false) Map<Long, Integer> carritos) {

        if (carritos == null) {
            carritos = new HashMap<>();
        }

        carritos.merge(id_peliculas, cantidad_items_carritos, Integer::sum);
        return "redirect:/carrito";
    }

    @PostMapping("/eliminar/{id_peliculas}")
    public String removeFromCart(@PathVariable Long id_peliculas, @SessionAttribute(value = "carrito", required = false) Map<Long, Integer> carritos) {

        if (carritos != null) {
            carritos.remove(id_peliculas);
        }

        return "redirect:/carrito";
    }
}