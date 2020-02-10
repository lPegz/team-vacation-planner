package br.pegz.tvp.security.controller;

import br.pegz.tvp.security.login.model.AuthenticationRequest;
import br.pegz.tvp.security.login.model.AuthenticationResponse;
import br.pegz.tvp.security.rbac.model.value.ConfirmationValue;
import br.pegz.tvp.security.rbac.model.value.UserAccountValue;
import br.pegz.tvp.security.rbac.service.UserLoginService;
import br.pegz.tvp.security.rbac.service.UserRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public final class UnsafeUserRegisterController {

    private final UserRegisterService userRegisterService;
    private final UserLoginService userLoginService;

    @PostMapping("/register")
    public ResponseEntity<ConfirmationValue> registerNewUser(@RequestBody UserAccountValue userAccountValue) {
        return ResponseEntity.ok(userRegisterService.registerNewUser(userAccountValue));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(userLoginService.authenticate(authenticationRequest));
    }

}
