package com.anusruta.expensewon.models.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetGroupResponse {
    private Long id;
    private String name;
    private List<GetUserResponse> users;
    private List<GetUserResponse> admins;
    private GetUserResponse createdBy;
}
