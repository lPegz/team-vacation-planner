package br.pegz.tvp.security.login.exception;

import org.springframework.security.core.AuthenticationException;

public class WrongPasswordException extends AuthenticationException {
    public WrongPasswordException(String explanation) {
        super(explanation);
    }

    public WrongPasswordException() {
        super("Password incorrect.");
    }
}
