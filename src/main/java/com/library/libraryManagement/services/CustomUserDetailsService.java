package com.library.libraryManagement.services;

import com.library.libraryManagement.entities.User;
import com.library.libraryManagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Charger l'utilisateur à partir du repository
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        // Retourner une instance de UserDetails
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                user.getRole().getAuthorities()); // Si vos rôles sont gérés comme des autorités
    }
}