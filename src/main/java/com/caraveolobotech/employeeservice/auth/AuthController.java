package com.caraveolobotech.employeeservice.auth;

import com.caraveolobotech.employeeservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        if (
                "admin".equals(request.getUsername()) &&
                "admin123".equals(request.getPassword())
        ) {

            String token =
                    jwtService.generateToken(request.getUsername());

            return new AuthResponse(token);
        }

        throw new RuntimeException("Invalid credentials");
    }
}