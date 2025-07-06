package com.anusruta.expensewon.services;

import com.anusruta.expensewon.models.dtos.SettleUpTransaction;
import com.anusruta.expensewon.models.entities.Expense;
import com.anusruta.expensewon.models.strategy.interfaces.SettlementStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SettlementService {

    private SettlementStrategy settlementStrategy;
    private ExpenseService expenseService;

    public List<SettleUpTransaction> settle(Long groupId){
        List<Expense> expenses = getExpenses(groupId);
        return settlementStrategy.settleExpenses(expenses);
    }

    public List<Expense> getExpenses(Long groupId){
        return expenseService.getExpensesByGroupId(groupId);
    }
}
