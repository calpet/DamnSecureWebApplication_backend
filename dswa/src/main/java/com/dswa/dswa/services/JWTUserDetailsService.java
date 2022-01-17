package com.dswa.dswa.services;


import com.dswa.dswa.interfaces.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class JWTUserDetailsService implements UserDetailsService {

    @Autowired(required = true)
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var entity = userRepository.findByEmail(username);
        List<SimpleGrantedAuthority> roles = null;
        if (entity != null) {
                roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
                return new User(entity.getEmail(), entity.getPassword(), roles);

        }
        else{
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
