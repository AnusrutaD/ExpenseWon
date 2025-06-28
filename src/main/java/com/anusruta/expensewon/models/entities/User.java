package com.anusruta.expensewon.models.entities;

import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
@Entity
public class User extends BaseModel{
    private String name;
    private String phone;
    private String email;
    private String hashedPassword;
}
