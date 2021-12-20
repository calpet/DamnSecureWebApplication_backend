package com.dswa.dswa.interfaces.repositories;

import com.dswa.dswa.models.ProductModel;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface GenericRepository<T> {
    List<T> getAll();
}
