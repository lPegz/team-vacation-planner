package br.pegz.tvp.security.rbac.service;

import br.pegz.tvp.security.rbac.model.value.ConfirmationValue;
import br.pegz.tvp.security.rbac.model.value.UserAccountValue;

public interface UserRegisterService {

    ConfirmationValue registerNewUser(UserAccountValue userAccountValue);

}
