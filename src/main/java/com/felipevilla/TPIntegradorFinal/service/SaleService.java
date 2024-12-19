package com.felipevilla.TPIntegradorFinal.service;



import com.felipevilla.TPIntegradorFinal.dto.BiggestsaleDTO;
import com.felipevilla.TPIntegradorFinal.model.Sale;
import com.felipevilla.TPIntegradorFinal.repository.SaleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
public class SaleService implements ISaleService{

    @Autowired
    SaleRepository saleRepository;

    //Method to create a new sale.
    @Override
    public void createSale(Sale sale) {
        saleRepository.save(sale);
    }

    //Method to read all sales.
    @Override
    public List<Sale> readAllSales() {
        return saleRepository.findAll();
    }

    //Method to read a particular sale.
    @Override
    public Sale readSale(Long codeSale) {
        return saleRepository.findById(codeSale).orElse(null);
    }

    //Method to delete a sale.
    @Override
    public void deleteSale(Long codeSale) {
        saleRepository.deleteById(codeSale);
    }

    //Method to update a sale.
    @Override
    public Sale updateSale(Long codeSale, Sale sale) {

        Sale existingSale = saleRepository.findById(codeSale)
                .orElseThrow(() -> new EntityNotFoundException("Venta no encontrada"));

        if (sale.getCodeSale() != null){
            existingSale.setCodeSale(sale.getCodeSale());
        }
        if (sale.getSaleDate() != null){
            existingSale.setSaleDate(sale.getSaleDate());
        }
        if (sale.getTotal() != null && !sale.getTotal().isInfinite()){
            existingSale.setTotal(sale.getTotal());
        }
        if (sale.getListProducts() != null && !sale.getListProducts().isEmpty()){
            existingSale.setCodeSale(sale.getCodeSale());
        }
        if (sale.getClient() != null){
            existingSale.setClient(sale.getClient());
        }

        return saleRepository.save(existingSale);
    }

    
    //Method to obtain sales by date.
    @Override
    public Map<String, Object> obtenerVentasPorFecha(LocalDate saleDate) {
        
    // Gets the amount of sales on that date 
    long cantidad = saleRepository.countBysaleDate(saleDate);

    // Gets the sum of the total sales on that date
    Double totalVentas = saleRepository.sumBySaleDate(saleDate);

    // We create the results map
    Map<String, Object> resultado = new HashMap<>(); 
    resultado.put("cantidad", cantidad);
    resultado.put("total", totalVentas != null ? totalVentas : 0.0); // If there are no sales, the total is 0

    return resultado;

    }


    // Method to obtain the sale with the highest total.
    @Override
    public BiggestsaleDTO obtenerVentaConMayorTotal() {

    Sale sale = saleRepository.findVentaConMayorTotal();
    
    if (sale== null) {
        throw new EntityNotFoundException("There are no sales recorded.");
    }

    int cantidadProductos = sale.getListProducts() != null ? sale.getListProducts().size() : 0;

    return new BiggestsaleDTO(sale.getCodeSale(),sale.getTotal(),
    cantidadProductos,sale.getClient() != null ? sale.getClient().getName() : null,
        sale.getClient() != null ? sale.getClient().getLastName() : null 
    );
    }




    
  
}
