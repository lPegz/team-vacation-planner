package br.pegz.tvp.security.rbac.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    MEMBER("isMember"),
    ADMIN("isAdmin");

    Role(String authority) {
        this.authority = authority;
    }

    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }
}
