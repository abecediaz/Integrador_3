package com.blockbuster.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import com.blockbuster.servicios.PeliculasServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/peliculas")
public class PeliculasControlador {

    @Autowired
    private PeliculasServicio peliculasServicio;

    @GetMapping
    public String listPeliculas(Model model) {
        model.addAttribute("peliculas", peliculasServicio.getAllPeliculas());
        return "peliculas";
    }

    @GetMapping("/{id_peliculas}")
    public String viewPeliculas(@PathVariable Long id_peliculas, Model model) {
        model.addAttribute("peliculas", peliculasServicio.getPeliculaById(id_peliculas));
        return "peliculas";
    }
}
