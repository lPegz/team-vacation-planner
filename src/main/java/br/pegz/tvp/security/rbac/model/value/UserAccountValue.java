package br.pegz.tvp.security.rbac.model.value;

import lombok.Value;

@Value
public class UserAccountValue {
    private final String teamName;
    private final String username;
    private final String email;
    private final String password;
}
