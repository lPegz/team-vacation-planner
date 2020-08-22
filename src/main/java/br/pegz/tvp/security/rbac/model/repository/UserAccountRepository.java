package br.pegz.tvp.security.rbac.model.repository;

import br.pegz.tvp.security.rbac.model.UserAccount;
import br.pegz.tvp.security.rbac.model.UserAccountId;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

@EnableScan
public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, UserAccountId> {

    Optional<UserAccount> findByTeamNameAndUsername(String teamName, String username);

}
