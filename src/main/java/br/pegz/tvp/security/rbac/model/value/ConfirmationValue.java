package br.pegz.tvp.security.rbac.model.value;

import lombok.Value;

@Value
public class ConfirmationValue {
    private final String username;
    private final String teamName;
}
