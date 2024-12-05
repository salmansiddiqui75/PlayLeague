package com.playleague.tournaments.controllers;

import com.playleague.tournaments.models.User;
import com.playleague.tournaments.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/signup/user")
    public ResponseEntity<User> signupUser(@RequestBody User user) {
        user.setRole("ROLE_USER");
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PostMapping("/signup/admin")
    public ResponseEntity<User> signupAdmin(@RequestBody User user) {
        user.setRole("ROLE_ADMIN");
        return ResponseEntity.ok(userService.createAdmin(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        boolean isAuthenticated = userService.authenticateUser(username, password);
        if (isAuthenticated) {
            User user = userService.getUserByUsername(username);
            return ResponseEntity.ok("Login successful! Role: " + user.getRole());
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
