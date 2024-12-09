package org.videosharing.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.videosharing.services.CreateUserService;

import java.io.IOException;

@RestController
@RequestMapping("auth")
@AllArgsConstructor

public class CreateAccController {
    public CreateUserService createUserService;
    @PostMapping("login")
    public ResponseEntity<String> createAcc(@RequestParam String login, @RequestParam String pass) throws IOException {
        return ResponseEntity.ok(createUserService.createUser(login,pass));
    }
}
