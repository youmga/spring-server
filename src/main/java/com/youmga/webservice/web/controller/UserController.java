package com.youmga.webservice.web.controller;

import com.youmga.webservice.domain.users.User;
import com.youmga.webservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @GetMapping("/get")
    public List<User> listUser() {
        return userService.findAll();
    }

    @PostMapping("/post")
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "success";
    }

}
