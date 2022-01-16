package com.dswa.dswa.services;

import com.dswa.dswa.interfaces.repositories.ProductRepository;
import com.dswa.dswa.models.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService implements com.dswa.dswa.interfaces.services.ProductService {
    private final ProductRepository productRepository;

@Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductModel> getAll() {
        return productRepository.getAll();
    }

    @Override
    public ProductModel getById(int id) {
        return null;
    }

    @Override
    public boolean create(ProductModel entity) {
        return false;
    }

    @Override
    public ProductModel update(ProductModel entity) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
