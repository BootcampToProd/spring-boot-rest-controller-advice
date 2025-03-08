package com.bootcamptoprod.controller;

import com.bootcamptoprod.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    private final Map<Integer, String> users = Map.of(1, "John Doe", 2, "Jane Doe");

    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable int id) {
        if (!users.containsKey(id)) {
            throw new UserNotFoundException("User not found with ID: " + id);
        }
        return users.get(id);
    }

}
