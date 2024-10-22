package com.blockbuster.entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.io.Serial;
import java.util.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "ordenes")
public class Ordenes implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ordenes;

    @Column(nullable = false)
    private BigDecimal monto_total;

    @ManyToOne
    @JoinColumn(name = "id_clientes")
    private Clientes cliente;

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemsOrdenes> item_orden = new ArrayList<>();
}