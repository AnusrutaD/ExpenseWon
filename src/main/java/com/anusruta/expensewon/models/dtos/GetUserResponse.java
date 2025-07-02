package com.anusruta.expensewon.models.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetUserResponse {
    private Long id;
    private String name;
    private String email;
    private String phone;
}
