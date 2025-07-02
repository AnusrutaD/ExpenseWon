package com.anusruta.expensewon.models.dtos;

import com.anusruta.expensewon.models.entities.Expense;
import com.anusruta.expensewon.models.entities.Group;
import com.anusruta.expensewon.models.entities.User;
import com.anusruta.expensewon.models.enums.Currency;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class CreateExpenseRequest {
    private String description;
    private Double amount;
    private Long createdById;
    private Currency currency;
    private List<Long> participantIds;
    private Map<Long, Double> paidBy;
    private Map<Long, Double> paidFor;
    private Long groupId;

    public Expense expense(User createdBy, List<User> participants, Group group){
        return Expense.builder()
                .description(this.description)
                .amount(this.amount)
                .createdBy(createdBy)
                .currency(this.currency)
                .participants(participants)
                .paidBy(this.paidBy)
                .paidFor(this.paidFor)
                .group(group)
                .build();
    }
}
