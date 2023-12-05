package com.spring.springsecurityjwt.domain.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AuthenticationRequest {

    private String email;
    private String password;
}
