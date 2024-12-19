package com.felipevilla.TPIntegradorFinal.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table (name = "sales")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codeSale;
    private LocalDate saleDate;
    private Double total;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Product> listProducts;

    @ManyToOne
    @JoinColumn(name = "idClient", referencedColumnName = "idClient")
    private Client client;

}
