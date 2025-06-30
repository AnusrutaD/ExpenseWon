package com.anusruta.expensewon.models.entities;


import com.anusruta.expensewon.models.enums.Currency;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Entity
@Table(name = "EXPENSES")
public class Expense extends BaseModel{
    private String description;
    private Double amount;

    @ManyToOne
    private User createdBy;

    @Enumerated
    private Currency currency;

    @ManyToMany
    private List<User> participants = new ArrayList<>();

    @ElementCollection
    private Map<User, Double> paidBy = new HashMap<>();

    @ElementCollection
    private Map<User, Double> paidFor = new HashMap<>();
}
