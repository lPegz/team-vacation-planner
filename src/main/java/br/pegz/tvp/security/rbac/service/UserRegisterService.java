package br.pegz.tvp.security.rbac.service;

import br.pegz.tvp.security.rbac.model.value.ConfirmationValue;
import br.pegz.tvp.security.rbac.model.value.UserAccountValue;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserRegisterService extends UserDetailsService {

    ConfirmationValue registerTenant(UserAccountValue userAccountValue);

}
