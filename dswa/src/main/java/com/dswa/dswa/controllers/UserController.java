package com.dswa.dswa.controllers;

import com.dswa.dswa.interfaces.services.UserService;
import com.dswa.dswa.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(@Qualifier("userService") UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/user")
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

    @PostMapping("/user")
    @ResponseBody
    public ResponseEntity<?> createUser(@RequestBody UserModel user) {
        boolean doubleEmails = this.userService.CheckForDoubleEmails(user);

        if (doubleEmails) {
            return ResponseEntity.badRequest().body("This user already exists! Please consider logging in.");
        }
        this.userService.create(user);
        return ResponseEntity.ok(user);
    }
}
