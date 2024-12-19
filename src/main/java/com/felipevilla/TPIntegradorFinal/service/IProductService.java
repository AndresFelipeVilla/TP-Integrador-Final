package com.felipevilla.TPIntegradorFinal.service;

import com.felipevilla.TPIntegradorFinal.model.Product;


import java.util.List;

public interface IProductService {

    //Method to create a new product.
    public void createProduct(Product product);

    //Method to read all products that have a quantity less than 5.
    public List<Product> getProductsWithLowStock();

    //Method to read all products. 
    List<Product> readAllProducts();

    //Method to read a particular product.
    public Product readProduct(Long codeProduct);

    //Method to delete a product.
    public void deleteProduct(Long codeProduct);

    //Method to update a product.
    public Product updateProduct(Long codeProduct, Product product);


}
