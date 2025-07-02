package com.anusruta.expensewon.services;

import com.anusruta.expensewon.models.dtos.RegisterRequest;
import com.anusruta.expensewon.models.entities.User;
import com.anusruta.expensewon.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    UserRepository repository;

    BCryptEncoder encoder;
    
    public User createUser(RegisterRequest request){
        request.setPassword(encoder.encode(request.getPassword()));
        return repository.save(request.toUser());
    }

    public User getUserById(Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<User> getAllUsersByIds(List<Long> ids){
        return repository.findAllById(ids);
    }

    public List<User> getAllUsersByIds() {
        return repository.findAll();
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
