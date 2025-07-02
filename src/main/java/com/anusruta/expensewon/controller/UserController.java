package com.anusruta.expensewon.controller;

import com.anusruta.expensewon.models.dtos.GetUserResponse;
import com.anusruta.expensewon.models.dtos.RegisterRequest;
import com.anusruta.expensewon.models.entities.User;
import com.anusruta.expensewon.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    UserService service;

    @PostMapping
    public GetUserResponse register(@RequestBody RegisterRequest request){
        // validate request
        validate(request);

        System.out.println("User Request: " + request.getName());
        return service.createUser(request).toResponse();
    }

    private void validate(RegisterRequest request) {
        if (request.getName() == null){
            throw new RuntimeException("Name is not present");
        }

        if (request.getEmail() == null){
            throw new RuntimeException("Email is not present");
        }

        if (request.getPhone() == null){
            throw new RuntimeException("Phone is not present");
        }

        if (request.getPassword() == null){
            throw new RuntimeException("Password is not present");
        }
    }

    @GetMapping("/{id}")
    public GetUserResponse getUserById(@PathVariable Long id){
        return service.getUserById(id).toResponse();
    }

    @GetMapping
    public List<GetUserResponse> getAllUsers(){
        return service.getAllUsers().stream().map(User::toResponse).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        service.deleteUser(id);
    }
}
