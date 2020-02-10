package br.pegz.tvp.security.login.exception;

import org.springframework.security.core.AuthenticationException;

public class UserNotFoundException extends AuthenticationException {
    public UserNotFoundException() {
        super("User not found");
    }
}
