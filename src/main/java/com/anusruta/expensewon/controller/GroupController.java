package com.anusruta.expensewon.controller;

import com.anusruta.expensewon.models.dtos.CreateGroupRequest;
import com.anusruta.expensewon.models.dtos.GetGroupResponse;
import com.anusruta.expensewon.models.entities.Group;
import com.anusruta.expensewon.services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/group")
@AllArgsConstructor
public class GroupController {

    private GroupService service;

    @PostMapping
    public GetGroupResponse createGroup(@RequestBody CreateGroupRequest request){
        return service.createGroup(request).toResponse();
    }

    @GetMapping("/{id}")
    public GetGroupResponse getGroupById(@PathVariable Long id){
        return service.getGroupById(id).toResponse();
    }

    @GetMapping
    public List<GetGroupResponse> getAllGroup(){
        return service.getAllGroup().stream().map(Group::toResponse).collect(Collectors.toList());
    }
}
