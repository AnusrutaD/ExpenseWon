package com.anusruta.expensewon.models.dtos;

import com.anusruta.expensewon.models.entities.User;
import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String phone;
    private String password;

    public User toUser(){
        return User.builder()
                .name(this.name)
                .email(this.email)
                .phone(this.phone)
                .hashedPassword(password)
                .build();
    }
}
