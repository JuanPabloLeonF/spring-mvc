package com.spring.springsecurityjwt.domain.service.authentication;

import com.spring.springsecurityjwt.domain.models.AuthenticationRequest;
import com.spring.springsecurityjwt.domain.models.AuthenticationResponse;
import com.spring.springsecurityjwt.domain.models.RegisterRequest;
import com.spring.springsecurityjwt.domain.service.jwt.JwtService;
import com.spring.springsecurityjwt.persistency.entity.Role;
import com.spring.springsecurityjwt.persistency.entity.User;
import com.spring.springsecurityjwt.persistency.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImplementationAuthenticationService implements IAuthenticationService{

    private final IUserRepository iUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .passwordUser(passwordEncoder.encode(request.getPasswordUser()))
                .role(Role.USER)
                .build();
        iUserRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = iUserRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
