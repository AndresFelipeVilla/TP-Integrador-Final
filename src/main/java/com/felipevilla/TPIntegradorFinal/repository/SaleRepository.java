package com.felipevilla.TPIntegradorFinal.repository;

import com.felipevilla.TPIntegradorFinal.model.Sale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;



public interface SaleRepository extends JpaRepository<Sale, Long> {  
    
    long countBysaleDate(LocalDate saleDate);

    @Query("SELECT SUM(s.total) FROM Sale s WHERE s.saleDate = :saleDate")
    Double sumBySaleDate(@Param("saleDate") LocalDate saleDate);
    
    @Query("SELECT s FROM Sale s WHERE s.total = (SELECT MAX(s2.total) FROM Sale s2)")
    Sale findVentaConMayorTotal(); 


}

