package com.blockbuster.entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.io.Serial;
import java.util.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "carritos")
public class Carritos implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carritos;

    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemsCarritos> item_carrito = new ArrayList<>();

    @OneToOne(mappedBy = "carrito")
    private Clientes cliente;
}