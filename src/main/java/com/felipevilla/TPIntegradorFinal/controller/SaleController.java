package com.felipevilla.TPIntegradorFinal.controller;



import com.felipevilla.TPIntegradorFinal.dto.BiggestsaleDTO;
import com.felipevilla.TPIntegradorFinal.model.Sale;
import com.felipevilla.TPIntegradorFinal.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;





@RestController
public class SaleController {

    @Autowired
    ISaleService saleService;

    @PostMapping("/ventas/crear")
    public String createSale(@RequestBody Sale sale){
        saleService.createSale(sale);
        return "La venta se creo correctamente";
    }

    @GetMapping("/ventas")
    public List<Sale> readAllSale (){
        return saleService.readAllSales();
    }

    @GetMapping("/ventas/{codeSale}")
    public Sale readSale (@PathVariable Long codeSale){
        return saleService.readSale(codeSale);
    }
   
    @GetMapping("/ventas/saleDate/total/{saleDate}")
    public ResponseEntity<Map<String, Object>> obtenerVentasPorFecha(@PathVariable String saleDate) {
    LocalDate fecha = LocalDate.parse(saleDate); // Convert String to LocalDate
    Map<String, Object> resultado = saleService.obtenerVentasPorFecha(fecha); // Pass LocalDate to the service
    return ResponseEntity.ok(resultado);
    }

    @GetMapping("/ventas/mayor_venta")
    public ResponseEntity<BiggestsaleDTO> obtenerVentaConMayorTotal() {
    BiggestsaleDTO ventaMayor = saleService.obtenerVentaConMayorTotal();
    return ResponseEntity.ok(ventaMayor);
    }

    @DeleteMapping("/ventas/eliminar/{codeSale}")
    public String deleteSale(@PathVariable Long codeSale){
        saleService.deleteSale(codeSale);
        return "La venta se elimino correctamente";
    }

    @PutMapping("/ventas/editar/{codeSale}")
    public Sale updateSale(@PathVariable Long codeSale, @RequestBody Sale sale ){
        return saleService.updateSale(codeSale, sale);
    }

    


}
