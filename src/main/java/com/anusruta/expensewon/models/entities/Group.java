package com.anusruta.expensewon.models.entities;

import com.anusruta.expensewon.models.dtos.GetGroupResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "GROUPS")
public class Group extends BaseModel{
    private String name;

    @ManyToMany
    private List<User> users = new ArrayList<>();

    @ManyToMany
    private List<User> admins = new ArrayList<>();

    @ManyToOne
    private User createdBy;

    public GetGroupResponse toResponse(){
        return GetGroupResponse.builder()
                .id(getId())
                .name(this.name)
                .users(this.users.stream().map(User::toResponse).collect(Collectors.toList()))
                .admins(this.admins.stream().map(User::toResponse).collect(Collectors.toList()))
                .createdBy(this.createdBy.toResponse())
                .build();
    }
}
