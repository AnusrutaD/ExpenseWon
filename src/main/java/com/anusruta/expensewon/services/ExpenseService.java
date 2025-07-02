package com.anusruta.expensewon.services;

import com.anusruta.expensewon.models.dtos.CreateExpenseRequest;
import com.anusruta.expensewon.models.entities.Expense;
import com.anusruta.expensewon.models.entities.Group;
import com.anusruta.expensewon.models.entities.User;
import com.anusruta.expensewon.repositories.ExpenseRepository;
import lombok.AllArgsConstructor;

import java.util.List;

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
}
