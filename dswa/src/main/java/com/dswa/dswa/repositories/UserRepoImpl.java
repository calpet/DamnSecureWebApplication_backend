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
        allUsers.add(new UserModel(1,"Student","Fontys","Student@Fontys.nl","$2a$12$pt2J4EvcZU.ChG/7EPsEfOROwWWvk0ChiZdYoUukAFHnDExpY5Awe"));
        allUsers.add(new UserModel(2,"Peter","Parker","PizzaBoy@BrooklinsPizza.com","StrongPassword123"));
        allUsers.add(new UserModel(3,"John","Doe","John.Doe@outlook.com","123456789"));

    }

    public List<UserModel> getAll() {
        return allUsers;
    }

    public UserModel findByEmail(String email){
        for (UserModel user : getAll()) {
            if(!CompareEmails(user, email)) {
                return user;
            }
        }
        return null;
    }


    public boolean CompareEmails(UserModel user, String email) {
        return user.getEmail() == email;
    }
}
