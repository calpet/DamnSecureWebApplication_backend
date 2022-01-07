package com.dswa.dswa.interfaces.repositories;


import com.dswa.dswa.models.UserModel;

public interface UserRepository extends GenericRepository<UserModel> {
    UserModel findByEmail(String email);
}
