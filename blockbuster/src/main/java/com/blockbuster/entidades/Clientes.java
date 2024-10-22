package com.blockbuster.entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.io.Serial;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "clientes")
public class Clientes implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_clientes;

    @Column(unique = true)
    private String usuario;

    @Column(nullable = false)
    private String contrasenia;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_carritos", referencedColumnName = "id_carritos")
    private Carritos carrito;
}