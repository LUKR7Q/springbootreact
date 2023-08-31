package com.example.demo.controller;

import com.example.demo.entity.TextEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/login")
    public ResponseEntity<Object> login(String id, String pw, String name) {

        String string = userService.login(id, pw);

        return ResponseEntity.ok().body(string);
    }


    @GetMapping("/signup")
    public ResponseEntity<Object> signup(String id, String pw, String name) {
        userService.signup(id, pw, name);

        return ResponseEntity.ok().body("success");
    }
}
