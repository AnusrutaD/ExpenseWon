package com.anusruta.expensewon.services;

import com.anusruta.expensewon.models.dtos.CreateExpenseRequest;
import com.anusruta.expensewon.models.entities.Expense;
import com.anusruta.expensewon.models.entities.Group;
import com.anusruta.expensewon.models.entities.User;
import com.anusruta.expensewon.repositories.ExpenseRepository;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExpenseService {
    private ExpenseRepository repository;
    private UserService userService;
    private GroupService groupService;


    public Expense createExpense(CreateExpenseRequest request) {
        User createdBy = userService.getUserById(request.getCreatedById());
        List<User> participants = userService.getAllUsersByIds(request.getParticipantIds());

        Group group = groupService.getGroupById(request.getGroupId());

        return repository.save(request.expense(createdBy, participants, group));
    }

    public Expense getExpenseByid(Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    public List<Expense> getExpensesByGroupId(Long groupId){
        return repository.findAll().stream()
                .filter(expense -> Objects.equals(expense.getGroup().getId(), groupId))
                .collect(Collectors.toList());
    }

    public void settleUp(Long id) {
        Expense expense = repository.findById(id).orElseThrow(RuntimeException::new);
        Map<Long, Double> transactions = new HashMap<>();
        for(Long paidForUserId: expense.getPaidFor().keySet()){
            transactions.put(paidForUserId, transactions.getOrDefault(paidForUserId, 0.0) - expense.getPaidBy().get(paidForUserId));
        }

        for(Long paidByUserId: expense.getPaidBy().keySet()){
            transactions.put(paidByUserId, transactions.getOrDefault(paidByUserId, 0.0) - expense.getPaidBy().get(paidByUserId));
        }
    }
}
