package com.blockbuster.controladores;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.blockbuster.servicios.OrdenesServicio;
import org.springframework.stereotype.Controller;
import com.blockbuster.entidades.Clientes;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/ordenes")
public class OrdenesControlador {

    @Autowired
    private OrdenesServicio ordenesServicio;

    @GetMapping
    public String viewOrdenes(Model model, @AuthenticationPrincipal Clientes cliente) {
        model.addAttribute("ordenes", ordenesServicio.getOrdenByCliente(cliente));
        return "ordenes";
    }
}
