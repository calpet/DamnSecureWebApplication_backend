package com.dswa.dswa.interfaces.repositories;

import com.dswa.dswa.models.ProductModel;

import java.util.List;

public interface GenericRepository {
    List<ProductModel> getAll();
}
