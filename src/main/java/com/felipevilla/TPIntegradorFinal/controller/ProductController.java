package com.felipevilla.TPIntegradorFinal.controller;



import com.felipevilla.TPIntegradorFinal.model.Product;
import com.felipevilla.TPIntegradorFinal.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
public class ProductController {

    @Autowired
    IProductService productService;

    @PostMapping("/productos/crear")
    public String createProduct( @RequestBody Product product){
        productService.createProduct(product);
        return "El producto se creo correctamente";
    } 
      
    @GetMapping("/productos/falta_Stock")
    public List<Product> getLowStockProducts() {
       // Call the service and return the list of products with low inventory
        return productService.getProductsWithLowStock();
    }

    @GetMapping("/productos")
    public List<Product> readAllProducts(){
        return productService.readAllProducts();
    }

    @GetMapping("/productos/{codeProduct}")
    public Product readProduct (@PathVariable Long codeProduct){
        return productService.readProduct(codeProduct);
    }

    @DeleteMapping("/productos/eliminar/{codeProduct}")
    public String deleteProduct (@PathVariable Long codeProduct){
        productService.deleteProduct(codeProduct);
        return "El producto se elimino correctamente";
    }

    @PutMapping("productos/editar/{codeProduct}")
    public Product updateProduct (@PathVariable Long codeProduct, @RequestBody Product product){
        return productService.updateProduct(codeProduct, product);
    }
}
