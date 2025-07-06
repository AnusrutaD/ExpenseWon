package com.anusruta.expensewon.models.dtos;

import com.anusruta.expensewon.models.entities.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SettleUpTransaction {
    private User from;
    private User to;
    private Double amount;
}
