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
@Table(name = "items_carritos")
public class ItemsCarritos implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_items_carritos;

    @Column(nullable = false)
    private int cantidad_items_carritos;

    @ManyToOne
    @JoinColumn(name = "id_carritos")
    private Carritos carrito;

    @ManyToOne
    @JoinColumn(name = "id_peliculas")
    private Peliculas pelicula;
}
