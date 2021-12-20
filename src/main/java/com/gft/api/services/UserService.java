package com.gft.api.services;

import com.gft.api.entities.User;
import com.gft.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUserByEmail(String email) {
        Optional<User> optional = userRepository.findByEmail(email);

        if(optional.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        return optional.get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findUserByEmail(username);
    }

    public User findUserById(Long idUser) {
        Optional<User> optional = userRepository.findById(idUser);

        if(optional.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        return optional.get();
    }
}
