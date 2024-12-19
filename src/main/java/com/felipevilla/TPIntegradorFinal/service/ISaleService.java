package com.felipevilla.TPIntegradorFinal.service;



import com.felipevilla.TPIntegradorFinal.dto.BiggestsaleDTO;
import com.felipevilla.TPIntegradorFinal.model.Sale;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public interface ISaleService {

    //Method to create a new sale.
    public void createSale(Sale sale);

    //Method to read all sales.
    List<Sale> readAllSales();

    //Method to read a particular sale. 
    public Sale readSale(Long codeSale);

    //Method to delete a sale.
    public void deleteSale(Long codeSale);

    //Method to update a sale.
    public Sale updateSale(Long codeSale, Sale sale);  

    //Method to obtain sales by date.  
    Map<String, Object> obtenerVentasPorFecha(LocalDate saleDate);

    // Method to obtain the sale with the highest total.
    public BiggestsaleDTO obtenerVentaConMayorTotal();

    
    
    
    
}
