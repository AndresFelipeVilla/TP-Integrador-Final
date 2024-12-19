package com.felipevilla.TPIntegradorFinal.repository;

import com.felipevilla.TPIntegradorFinal.model.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByAvailableQuantityLessThan(double quantity); 
}
