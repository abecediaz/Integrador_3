package com.blockbuster.entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.io.Serial;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "items_ordenes")
public class ItemsOrdenes implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_items_ordenes;

    @Column(nullable = false)
    private int cantidad_items_ordenes;

    @Column(nullable = false)
    private BigDecimal precio_items_ordenes;

    @ManyToOne
    @JoinColumn(name = "id_ordenes")
    private Ordenes orden;

    @ManyToOne
    @JoinColumn(name = "id_peliculas")
    private Peliculas pelicula;
}
