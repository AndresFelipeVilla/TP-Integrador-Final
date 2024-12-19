package com.felipevilla.TPIntegradorFinal.service;

import com.felipevilla.TPIntegradorFinal.model.Product;
import com.felipevilla.TPIntegradorFinal.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepository productRepository;


    //Method to create a new product.
    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    //Method to read all products.
    @Override
    public List<Product> readAllProducts() {
        return productRepository.findAll();
    }

    //Method to read a particular client.
    @Override
    public Product readProduct(Long codeProduct) {
        return productRepository.findById(codeProduct).orElse(null);
    }

    //Method to delete a product.
    @Override
    public void deleteProduct(Long codeProduct) {
        productRepository.deleteById(codeProduct);
    }

    //Method to update a product.
    @Override
    public Product updateProduct(Long codeProduct, Product product){

        Product existingProduct = productRepository.findById(codeProduct)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));

        if(product.getCodeProduct() != null ){
            existingProduct.setCodeProduct(product.getCodeProduct());
        }
        if (product.getName() != null && !product.getName().isEmpty()) {
            existingProduct.setName(product.getName());
        }
        if (product.getBrand() != null && !product.getBrand().isEmpty()) {
            existingProduct.setBrand(product.getBrand());
        }
        if (product.getCost() != null && !product.getCost().isInfinite()) {
            existingProduct.setCost(product.getCost());
        }
            if (product.getAvailableQuantity() != null && !product.getAvailableQuantity().isInfinite()) {
            existingProduct.setAvailableQuantity(null);(product.getAvailableQuantity()).isInfinite();
        }

        return productRepository.save(existingProduct);

    }

    //Method to read all products that have a quantity less than 5.
    @Override
    public List<Product> getProductsWithLowStock() {
        return productRepository.findByAvailableQuantityLessThan(5.0);
    }

    
}

