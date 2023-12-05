package com.spring.springsecurityjwt.domain.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AuthenticationResponse {

    private String token;
}
