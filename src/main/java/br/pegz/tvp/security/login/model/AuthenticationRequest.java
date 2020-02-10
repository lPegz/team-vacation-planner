package br.pegz.tvp.security.login.model;

import lombok.Value;

@Value
public class AuthenticationRequest {
    String teamName;
    String memberUsername;
    String passwordHash;
}
