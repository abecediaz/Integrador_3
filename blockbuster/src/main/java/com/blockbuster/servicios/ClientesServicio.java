package com.blockbuster.servicios;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import com.blockbuster.repositorios.ClientesRepositorio;
import org.springframework.stereotype.Service;
import com.blockbuster.entidades.Clientes;
import java.util.*;

@Service
public class ClientesServicio implements UserDetailsService {

    @Autowired
    private ClientesRepositorio clientesRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Clientes registerNewCliente(Clientes cliente) {
        cliente.setContrasenia(passwordEncoder.encode(cliente.getContrasenia()));
        return clientesRepositorio.save(cliente);
    }

    public List<Clientes> listarClientes() {
        return clientesRepositorio.findAll();
    }

    public Clientes getLoggedUsername() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            String usuario = authentication.getName();
            return clientesRepositorio.findByUsuario(usuario).orElse(null);
        }

        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
