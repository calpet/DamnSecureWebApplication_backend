package com.dswa.dswa.services;

import com.dswa.dswa.interfaces.repositories.UserRepository;
import com.dswa.dswa.models.UserModel;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService implements com.dswa.dswa.interfaces.services.UserService{

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository  = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean create(UserModel user){
        PasswordEncoder(user);
        repository.save(user);
        return this.getAll().contains(user);
    }

    @Override
    public UserModel getById(int id){
        return repository.findById(id).get();
    }

    @Override
    public List<UserModel> getAll(){
        return repository.findAll();
    }

    @Override
    public UserModel update (UserModel entity){
        PasswordEncoder(entity);
        UserModel existing = this.getById(entity.getId());
        existing.setId(entity.getId());
        existing.setFirstname(entity.getFirstname());
        existing.setLastname(entity.getLastname());
        existing.setEmail(entity.getEmail());
        existing.setPassword(entity.getPassword());

        repository.save(existing);
        return existing;
    }

    @Override
    public void delete(int id){
        repository.deleteById(id);
    }

    @Override
    public void PasswordEncoder(UserModel entity){
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
    }

    @Override
    public boolean CheckForDoubleEmails(UserModel user){
        boolean doublevalues = false;
        var getallUsers = repository.findAll();

        for (var item :getallUsers) {
            if(user.getEmail().equals(item.getEmail())){
                doublevalues = true;
            }
        }
        return doublevalues;
    }
    @Override
    public boolean Validepassword(UserModel entity){
        Matcher matcher = pattern.matcher(entity.getPassword());
        return matcher.matches();
    }
}
