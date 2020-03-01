package br.pegz.tvp.security.rbac.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

@Data
@Builder
public class UserAccount implements UserDetails {
    @Id
    private final String tenantId;
    private final String teamName;
    private final String username;
    private final byte[] password;
    private final byte[] passwordSalt;
    private final String email;
    private final Set<Role> authorities;
    private final boolean accountNonExpired;
    private final boolean accountNonLocked;
    private final boolean credentialsNonExpired;
    private final boolean enabled;
}
