package com.buildingdev.tools.service;

import com.buildingdev.tools.entities.Product;
import com.buildingdev.tools.exception.ProductNotFoundException;
import com.buildingdev.tools.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    public List<Product> findAll() {

        return productRepository.findAll();
    }

    public Product findById(long id) {

        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Produto nao encontrado id: " + id));

        return product;
    }


}
