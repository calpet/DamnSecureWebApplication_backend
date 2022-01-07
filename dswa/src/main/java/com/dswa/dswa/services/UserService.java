package com.dswa.dswa.services;

import com.dswa.dswa.interfaces.repositories.UserRepository;
import com.dswa.dswa.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService implements com.dswa.dswa.interfaces.services.UserService{
    private final UserRepository userRepository;
    private List<UserModel> userModelList;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserModel> getAll() {
        return userRepository.getAll();
    }

    public UserModel findbyEmail(String email){
        userModelList = getAll();
        for (UserModel user: userModelList) {
                if(email.equals(user.getEmail()))
                    return user;
        }
        return null;
    }
}
