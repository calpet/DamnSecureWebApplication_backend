package com.dswa.dswa.interfaces.services;

import com.dswa.dswa.models.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends GenericService<UserModel> {
        void PasswordEncoder(UserModel user);
        boolean CheckForDoubleEmails(UserModel user);
        boolean Validepassword(UserModel entity);
}
