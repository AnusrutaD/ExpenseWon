package com.anusruta.expensewon.models.dtos;

import com.anusruta.expensewon.models.enums.Currency;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class GetExpenseResponse {
    private Long id;
    private String description;
    private Double amount;
    private GetUserResponse createdBy;
    private Currency currency;
    private List<GetUserResponse> participants;
    private Map<Long, Double> paidBy;
    private Map<Long, Double> paidFor;
    private GetGroupResponse group;
}
