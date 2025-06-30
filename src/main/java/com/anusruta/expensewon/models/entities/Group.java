package com.anusruta.expensewon.models.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "GROUPS")
public class Group extends BaseModel{
    private String name;

    @ManyToMany
    private List<User> users = new ArrayList<>();

    @ManyToMany
    private List<User> admins = new ArrayList<>();

    @ManyToOne
    private User createdBy;
}
