package com.anusruta.expensewon.services;

import com.anusruta.expensewon.models.entities.User;
import com.anusruta.expensewon.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Arrays;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    UserRepository repository;
    
    public User createUser(User user){
        return repository.save(user);
    }

    public User getUserById(Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
