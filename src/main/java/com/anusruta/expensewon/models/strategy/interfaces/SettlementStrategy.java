package com.anusruta.expensewon.models.strategy.interfaces;

import com.anusruta.expensewon.models.dtos.SettleUpTransaction;
import com.anusruta.expensewon.models.entities.Expense;

import java.util.List;

public interface SettlementStrategy {

    List<SettleUpTransaction> settleExpenses(List<Expense> expenses);
}
