package com.dswa.dswa.services;

import com.dswa.dswa.interfaces.repositories.ProductRepository;
import com.dswa.dswa.interfaces.services.IProductService;
import com.dswa.dswa.models.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    private final ProductRepository productRepository;

@Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductModel> getAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductModel getById(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public boolean create(ProductModel entity) {
        productRepository.save(entity);
        return this.getAll().contains(entity);

    }

    @Override
    public ProductModel update(ProductModel entity){
            ProductModel existing = this.getById(entity.getId());
            existing.setId(entity.getId());
            existing.setProductname(entity.getProductname());
            existing.setName(entity.getName());
            existing.setStocklevels(entity.getStocklevels());

            productRepository.save(existing);
            return existing;

        }

    @Override

    public void delete(int id){
        productRepository.deleteById(id);
    }

    @Override
    public boolean CheckForDoubleValues(ProductModel product){
        boolean doublevalues = false;
        var getAllProducts = productRepository.findAll();

        for (var item :getAllProducts) {
            if(product.getName().equals(item.getName())){
                doublevalues = true;
            }
        }
        return doublevalues;
    }

}
