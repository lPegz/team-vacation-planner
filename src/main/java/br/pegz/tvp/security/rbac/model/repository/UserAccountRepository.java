package br.pegz.tvp.security.rbac.model.repository;

import br.pegz.tvp.security.rbac.model.UserAccount;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, String> {

    Optional<UserAccount> findByTeamNameAndUsername(String teamName, String username);

}
