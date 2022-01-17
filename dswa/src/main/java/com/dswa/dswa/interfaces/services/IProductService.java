package com.dswa.dswa.interfaces.services;

import com.dswa.dswa.models.ProductModel;
import org.springframework.stereotype.Service;

@Service
public interface IProductService extends GenericService<ProductModel> {
    boolean CheckForDoubleValues(ProductModel product);
}
