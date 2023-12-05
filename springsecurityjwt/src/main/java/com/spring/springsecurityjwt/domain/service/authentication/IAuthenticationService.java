package com.spring.springsecurityjwt.domain.service.authentication;

import com.spring.springsecurityjwt.domain.models.AuthenticationRequest;
import com.spring.springsecurityjwt.domain.models.AuthenticationResponse;
import com.spring.springsecurityjwt.domain.models.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface IAuthenticationService {

    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
