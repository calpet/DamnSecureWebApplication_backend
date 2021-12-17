package com.dswa.dswa.repositories;

import com.dswa.dswa.interfaces.repositories.ProductRepository;
import com.dswa.dswa.models.ProductModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepoImpl implements ProductRepository {
    private final List<ProductModel> allProducts;

    public ProductRepoImpl() {
        allProducts = new ArrayList<>();
        allProducts.add(new ProductModel(1, "Tomato", "Vegetable"));
        allProducts.add(new ProductModel(2, "Apple", "Fruit"));
        allProducts.add(new ProductModel(3, "Sofa", "Furniture"));

    }

    public List<ProductModel> getAll() {
        return allProducts;
    }

}
