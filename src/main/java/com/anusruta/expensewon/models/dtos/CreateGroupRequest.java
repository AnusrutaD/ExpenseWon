package com.anusruta.expensewon.models.dtos;

import com.anusruta.expensewon.models.entities.Group;
import com.anusruta.expensewon.models.entities.User;
import lombok.Data;

import java.util.List;

@Data
public class CreateGroupRequest {
    private String name;
    private List<Long> userIds;
    private List<Long> adminIds;
    private Long createdByUserId;

    public Group group(List<User> users, List<User> admins, User createdBy){
        return Group.builder()
                .name(this.name)
                .users(users)
                .admins(admins)
                .createdBy(createdBy)
                .build();
    }
}
