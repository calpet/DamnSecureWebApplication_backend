package com.dswa.dswa.controllers;

import com.dswa.dswa.interfaces.services.ProductService;
import com.dswa.dswa.interfaces.services.UserService;
import com.dswa.dswa.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ResponseEntity<?> getAllProducts() {
        List<UserModel> users = userService.getAll();
        return ResponseEntity.ok(users);
    }
}
