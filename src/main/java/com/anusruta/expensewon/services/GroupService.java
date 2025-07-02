package com.anusruta.expensewon.services;

import com.anusruta.expensewon.models.dtos.CreateGroupRequest;
import com.anusruta.expensewon.models.entities.Group;
import com.anusruta.expensewon.models.entities.User;
import com.anusruta.expensewon.repositories.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GroupService {

    private GroupRepository repository;
    private UserService userService;

    public Group createGroup(CreateGroupRequest request){
        List<User> users = userService.getAllUsersByIds(request.getUserIds());
        List<User> admins = userService.getAllUsersByIds(request.getAdminIds());
        User createdBy = userService.getUserById(request.getCreatedByUserId());
        Group newGroup = request.group(users, admins, createdBy);
        return repository.save(newGroup);
    }

    public Group getGroupById(Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Group> getAllGroup() {
        return repository.findAll();
    }
}
