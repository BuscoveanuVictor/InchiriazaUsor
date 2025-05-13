package org.example.inchiriazausor.service;

import java.util.Collection;
import java.util.Iterator;

import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.example.inchiriazausor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository; // MongoDB repository

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Căutăm utilizatorul în baza de date
        User user = (User) userRepository.findByUsername(username);
        

        // Îl transformăm în UserDetails
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(), // Parolă deja criptată
                getAuthorities(user.getRoles())
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Iterator<Role> roles) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
        return null;
    }
}
