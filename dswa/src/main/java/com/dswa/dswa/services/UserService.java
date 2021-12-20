package com.dswa.dswa.services;

import com.dswa.dswa.interfaces.repositories.UserRepository;
import com.dswa.dswa.interfaces.repositories.UserRepository;
import com.dswa.dswa.models.ProductModel;
import com.dswa.dswa.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService implements com.dswa.dswa.interfaces.services.UserService{
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserModel> getAll() {
        return userRepository.getAll();
    }
}
