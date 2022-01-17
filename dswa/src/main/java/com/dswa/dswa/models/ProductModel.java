package com.dswa.dswa.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="product")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name= "Brand_name")
    @NotNull
    private String name;

    @Column(name="Product_name")
    @NotNull
    private String productname;

    @Column(name="Stocklevels")
    @NotNull
    private int stocklevels;

    public ProductModel(int id, String name, String productname, int stocklevels) {
        this.id = id;
        this.name = name;
        this.productname = productname;
        this.stocklevels = stocklevels;
    }

    public ProductModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String description) {
        this.productname = description;
    }

    public int getStocklevels(){return stocklevels;}
    public void setStocklevels(int stocklevels){this.stocklevels = stocklevels;}


}
