package app.controller;

import app.entity.UserEntity;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/kotiki/admin")
public class AdminController {
    @Autowired
    private UserService service;

    public AdminController() {
    }

    @GetMapping("/all")
    public List<UserEntity> getAllUsers() {
        return service.allUsers();
    }

    @GetMapping("/user/{id}")
    public UserEntity getUser(@PathVariable Integer id) throws ChangeSetPersister.NotFoundException {
        return service.findUserById(id);
    }

    @PostMapping("/giverole/{id}/{roleid}")
    public void giveRole(@PathVariable Integer id, @PathVariable Integer roleId) {
        service.giveRole(id, roleId);
    }
}
