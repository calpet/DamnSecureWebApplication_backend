package com.dswa.dswa.repositories;

import com.dswa.dswa.interfaces.repositories.UserRepository;
import com.dswa.dswa.models.UserModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepoImpl implements UserRepository {
    private List<UserModel>allUsers;

    public UserRepoImpl() {
        allUsers = new ArrayList<>();
        allUsers.add(new UserModel(1,"Peter","Parker","PizzaBoy@BrooklinsPizza.com","StrongPassword123"));
        allUsers.add(new UserModel(2,"Peter","Parker","PizzaBoy@BrooklinsPizza.com","StrongPassword123"));
        allUsers.add(new UserModel(3,"Peter","Parker","PizzaBoy@BrooklinsPizza.com","StrongPassword123"));

    }

    public List<UserModel> getAll() {
        return allUsers;
    }

}
