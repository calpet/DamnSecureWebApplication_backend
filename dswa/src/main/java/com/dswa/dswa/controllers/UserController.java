package com.dswa.dswa.controllers;

import com.dswa.dswa.interfaces.services.ProductService;
import com.dswa.dswa.interfaces.services.UserService;
import com.dswa.dswa.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService service) {
        this.userService = service;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> getAllUsers() {
        try {
            List<UserModel> model = userService.getAll();
            return new ResponseEntity<>(model, HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/email/{email}")
    @ResponseBody
    public ResponseEntity<UserModel> findEmailUser(@PathVariable(value = "email") String email) {
        try {
            UserModel model = userService.findbyEmail(email);
            return new ResponseEntity<>(model, HttpStatus.OK);
        }
        catch(NoSuchElementException exception){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
