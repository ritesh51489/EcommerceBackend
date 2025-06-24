package com.backend.Ecommerce.Controller;

import com.backend.Ecommerce.Service.UserService;
import com.backend.Ecommerce.model.Userdata;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.backend.Ecommerce.model.User;
@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/add")
    public Userdata addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/login")
    public Userdata loginUser(@RequestBody User user) {
        return userService.loginUser(user);
    }

}
