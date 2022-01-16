package com.dswa.dswa.interfaces.services;

import com.dswa.dswa.models.ProductModel;

import java.util.List;

public interface GenericService<T> {
    List<T> getAll();

    T getById(int id);

    boolean create(T entity);

    T update(T entity);

    void delete(int id);
}
