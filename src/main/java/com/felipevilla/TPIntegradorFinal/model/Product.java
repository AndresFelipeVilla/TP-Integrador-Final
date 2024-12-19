package com.felipevilla.TPIntegradorFinal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codeProduct;
    private String name;
    private String brand;
    private Double cost;
    private Double availableQuantity; 

    @ManyToOne
    @JoinColumn(name = "codeSale") // The foreign key that points to the sale
    @JsonBackReference
    private Sale sale;

}
