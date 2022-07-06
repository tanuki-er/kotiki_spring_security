package app.controller;

import app.entity.UserEntity;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    public AuthController() {
    }

    @PostMapping(value = "/register", consumes = {"*/*"})
    public void registerNewUser(@RequestBody UserEntity userDTO) {
        Integer id = userService.register(userDTO);

    }
}
