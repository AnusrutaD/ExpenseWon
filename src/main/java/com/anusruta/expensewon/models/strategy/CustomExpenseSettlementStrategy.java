package com.anusruta.expensewon.models.strategy;

import com.anusruta.expensewon.models.dtos.SettleUpTransaction;
import com.anusruta.expensewon.models.entities.Expense;
import com.anusruta.expensewon.models.strategy.interfaces.SettlementStrategy;
import com.anusruta.expensewon.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class CustomExpenseSettlementStrategy implements SettlementStrategy {

    public Map<Long, Double> balance(List<Expense> expenses){
        Map<Long, Double> transactions = new HashMap<>();
        for(Expense expense: expenses) {
            for (Long paidForUserId : expense.getPaidFor().keySet()) {
                transactions.put(paidForUserId, transactions.getOrDefault(paidForUserId, 0.0) - expense.getPaidBy().get(paidForUserId));
            }

            for (Long paidByUserId : expense.getPaidBy().keySet()) {
                transactions.put(paidByUserId, transactions.getOrDefault(paidByUserId, 0.0) - expense.getPaidBy().get(paidByUserId));
            }
        }
        return transactions;
    }

    @Override
    public List<SettleUpTransaction> settleExpenses(List<Expense> expenses) {
        Map<Long, Double> balancedTransactions = balance(expenses);
        TreeSet<Pair<Long, Double>> transactionSet = new TreeSet<>((p1, p2) -> p1.getValue().compareTo(p2.getValue()));
        while(!transactionSet.isEmpty()){
            Pair<Long, Double> minimum = transactionSet.getFirst();
            transactionSet.remove(minimum);
            Pair<Long, Double> maximum = transactionSet.getLast();
            transactionSet.remove(maximum);
            maximum.setValue(maximum.getValue() + minimum.getValue());
            if (maximum.getValue() != 0){
                transactionSet.add(maximum);
            }
        }
        return List.of();
    }
}
