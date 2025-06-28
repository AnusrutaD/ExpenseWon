package com.anusruta.expensewon.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import java.util.List;

@Getter
@Entity
public class Group extends BaseModel{
    private String name;

    @ManyToMany
    private List<User> users;

    @ManyToMany
    private List<User> admins;

    @OneToMany
    private User createdBy;
}
