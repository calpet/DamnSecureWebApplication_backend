package com.dswa.dswa.controllers;

import com.dswa.dswa.interfaces.services.IProductService;
import com.dswa.dswa.models.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Qualifier("productService")
    @Autowired
    private IProductService service;


    @GetMapping("/product")
    public ResponseEntity<List<ProductModel>> getProducts(){
        try {
            List<ProductModel> products = service.getAll();
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
        catch (NoSuchElementException exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseBody
    @GetMapping(path="product/{id}")
    public ResponseEntity<ProductModel> GetproductByID (@PathVariable(value = "id") int productID)  {
        try {
            ProductModel product = service.getById(productID);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        catch(NoSuchElementException exception){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseBody
    @PostMapping("/product")
    public ResponseEntity CreateProduct(@RequestBody ProductModel product){
        boolean checkForDoubleValues = service.CheckForDoubleValues(product);
        if(checkForDoubleValues){
            return ResponseEntity.badRequest().body("An error has occured, Please try again later!");
        }
        else {
            service.create(product);
            return ResponseEntity.ok(product);
        }
    }



    @PutMapping("/product/{id}")
    public ResponseEntity UpdateProduct(@PathVariable ("id") int productId, @RequestBody ProductModel updatedproduct){
        ProductModel entity = service.getById(productId);
        if (entity == null) {
            return ResponseEntity.badRequest().body("This product does not exist!");
        }
        ProductModel product = service.update(updatedproduct);
        return ResponseEntity.ok(product);
    }


    @DeleteMapping("/product/{id}")
    public ResponseEntity deleteproduct(@PathVariable("id") int id){
        try{
            this.service.delete(id);
        }
        catch (Exception exception) {
            return ResponseEntity.badRequest().body("Product with id: " + id + " was not found!");
        }
        return ResponseEntity.ok().body("Product with id: "+ id+ " has been deleted!");
    }

}
