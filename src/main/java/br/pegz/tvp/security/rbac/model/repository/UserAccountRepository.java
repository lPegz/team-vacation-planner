package br.pegz.tvp.security.rbac.model.repository;

import br.pegz.tvp.security.rbac.model.UserAccount;

import java.util.Optional;

public interface UserAccountRepository {

    Optional<UserAccount> findByTeamNameAndUsername(String teamName, String username);
    UserAccount save(UserAccount model);

}
