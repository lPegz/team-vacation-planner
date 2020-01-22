package br.pegz.tvp.security.controller;

import br.pegz.tvp.security.rbac.model.value.ConfirmationValue;
import br.pegz.tvp.security.rbac.model.value.UserAccountValue;
import br.pegz.tvp.security.rbac.service.UserRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public final class UnsafeUserRegisterController {

    private final UserRegisterService userRegisterService;

    @PostMapping
    public ResponseEntity<ConfirmationValue> registerNewUser(@RequestBody UserAccountValue userAccountValue) {
        return ResponseEntity.ok(userRegisterService.registerNewUser(userAccountValue));
    }

}
