package com.anusruta.expensewon.controller;

import com.anusruta.expensewon.models.dtos.CreateExpenseRequest;
import com.anusruta.expensewon.models.dtos.GetExpenseResponse;
import com.anusruta.expensewon.models.entities.Expense;
import com.anusruta.expensewon.services.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/expense")
@AllArgsConstructor
public class ExpenseController {

    private ExpenseService service;

    @PostMapping
    public GetExpenseResponse createExpense(@RequestBody CreateExpenseRequest request){
        return service.createExpense(request).toResponse();
    }

    @GetMapping("/{id}")
    public GetExpenseResponse getExpenseById(@PathVariable Long id){
        return service.getExpenseByid(id).toResponse();
    }

    @GetMapping
    public List<GetExpenseResponse> getAllExpenses(){
        return service.getAllExpenses().stream().map(Expense::toResponse).collect(Collectors.toList());
    }
}
