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
@Table(name = "peliculas")
public class Peliculas implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_peliculas;

    @Column(nullable = false)
    private String titulo_peliculas;

    private String descripcion_peliculas;

    private String genero_peliculas;

    @Column(nullable = false)
    private BigDecimal precio_peliculas;

    @Column(nullable = false)
    private String portada_peliculas;
}