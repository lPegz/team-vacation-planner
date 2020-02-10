package br.pegz.tvp.security.rbac.service;

import br.pegz.tvp.security.login.model.AuthenticationRequest;
import br.pegz.tvp.security.login.model.AuthenticationResponse;
import org.springframework.security.core.AuthenticationException;

public interface UserLoginService {

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) throws AuthenticationException;
    
}
