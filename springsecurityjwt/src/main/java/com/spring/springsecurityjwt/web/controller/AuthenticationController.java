package com.spring.springsecurityjwt.web.controller;

import com.spring.springsecurityjwt.domain.models.AuthenticationRequest;
import com.spring.springsecurityjwt.domain.models.AuthenticationResponse;
import com.spring.springsecurityjwt.domain.models.RegisterRequest;
import com.spring.springsecurityjwt.domain.service.authentication.IAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
public class AuthenticationController {

    private final IAuthenticationService iAuthenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(iAuthenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(iAuthenticationService.authenticate(request));
    }
}
