package br.pegz.tvp.security.rbac.model.value;

import lombok.Value;

@Value
public class UserAccountValue {
    String teamName;
    String username;
    String email;
    String password;
}
