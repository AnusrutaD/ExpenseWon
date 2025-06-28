package com.anusruta.expensewon.models.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@Entity
public class Expense extends BaseModel{
    private String description;
    private Double amount;
    private String currency;

    @ManyToMany
    private List<User> participants;

    private Map<User, Double> paidBy;
    private Map<User, Double> paidFor;

    @OneToMany
    private Group group;
}
