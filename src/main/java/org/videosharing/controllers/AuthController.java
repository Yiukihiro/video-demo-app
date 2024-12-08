package org.videosharing.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.videosharing.services.AuthService;

import java.io.IOException;

@RestController
@RequestMapping("auth")
@AllArgsConstructor

public class AuthController {
    public AuthService authService;
    @GetMapping("login")
    public ResponseEntity<String> loginAcc(@RequestParam("login") String login, @RequestParam("password") String pass) throws IOException {
        return ResponseEntity.ok(authService.loginAccess(login,pass));
    }
}
