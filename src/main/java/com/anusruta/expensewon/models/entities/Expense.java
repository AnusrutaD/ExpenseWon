package com.anusruta.expensewon.models.entities;


import com.anusruta.expensewon.models.dtos.GetExpenseResponse;
import com.anusruta.expensewon.models.enums.Currency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
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
    private Map<Long, Double> paidBy = new HashMap<>();

    @ElementCollection
    private Map<Long, Double> paidFor = new HashMap<>();

    @ManyToOne
    private Group group;

    public GetExpenseResponse toResponse() {
        return GetExpenseResponse.builder()
                .id(getId())
                .description(this.description)
                .amount(this.amount)
                .createdBy(this.createdBy.toResponse())
                .currency(this.currency)
                .participants(this.participants.stream().map(User::toResponse).collect(Collectors.toList()))
                .paidBy(this.paidBy)
                .paidFor(this.paidFor)
                .group(this.group.toResponse())
                .build();
    }
}
